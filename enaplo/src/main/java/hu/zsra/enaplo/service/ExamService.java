package hu.zsra.enaplo.service;

import hu.zsra.enaplo.dto.ExamDTO;
import hu.zsra.enaplo.dto.response.ExamResponseDTO;
import hu.zsra.enaplo.model.Exam;

import java.time.LocalDate;
import java.util.List;

/**
 * This interface contains all related function definitions to the exam.
 */
public interface ExamService {

    /**
     * Returns a List of Exams that written by student on the course.
     *
     * @param student_id Id of the Student.
     * @param course_id Id of the Course.
     * @return List of the exams.
     */
    List<Exam> findAllByStudent(Long student_id, Long course_id);

    /**
     * Creates a new exam and save into the database.
     *
     * @param examResponseDTO Submitted DTO from web application.
     * @return  a new Exam object.
     * @see Exam
     */
    Exam create(ExamResponseDTO examResponseDTO);

    /**
     * Updates a exam from database by id.
     *
     * @param id Id of the exam.
     * @param examResponseDTO Submitted DTO from web application.
     * @return an updated exam.
     * @see Exam
     */
    Exam update(Long id, ExamResponseDTO examResponseDTO);

    /**
     * Deletes a exam from database by id.
     *
     * @param id Id of the exam.
     */
    void delete(Long id);

    /**
     * Returns a form that contains a list of students
     * and mark field for each student.
     *
     * @param classroom_id Id of the classroom.
     * @param written_at The exam date.
     * @return A form table to create exams to all student in classroom.
     */
    List<ExamDTO> makeExamsFormToClassroom(Long classroom_id, LocalDate written_at);

    /**
     * Creates a new exams and save into the database.
     *
     * @param examResponseDTOS Submitted DTOs from web application.
     * @return  a new Exam objects.
     * @see Exam
     */
    List<Exam> createExamsFromForm(List<ExamResponseDTO> examResponseDTOS);
}
