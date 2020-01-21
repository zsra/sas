package hu.zsra.enaplo.service;

import hu.zsra.enaplo.dto.response.StudentResponseDTO;
import hu.zsra.enaplo.dto.SummaryDTO;
import hu.zsra.enaplo.model.user.group.Student;

import java.util.List;

/**
 * This interface contains all related function definitions to the student.
 */
public interface StudentService {

    /**
     * Returns a List of Students.
     *
     * @return students from database.
     */
    List<Student> findAll();

    /**
     * Returns a Students object by id, if student exist
     * or returns a null value.
     *
     * @param id Id of the student.
     * @return a student object by id.
     * @see Student
     */
    Student findById(Long id);

    /**
     * Returns a Students object by username, if student exist
     * or returns a null value.
     *
     * @param user_id Id of the student user.
     * @return a student object by user id.
     * @see Student
     */
    Student findByUserId(Long user_id);

    /**
     * Creates a new student and save into the database.
     *
     * @param studentResponseDTO Submitted DTO from web application.
     * @return  a new Student object.
     * @see Student
     */
    Student create(StudentResponseDTO studentResponseDTO);

    /**
     * Updates a student from database by id.
     *
     * @param id Id of the student.
     * @param studentResponseDTO Submitted DTO from web application.
     * @return an updated student.
     * @see Student
     */
    Student update(Long id, StudentResponseDTO studentResponseDTO);

    /**
     * Deletes a student from database by id.
     *
     * @param id Id of the student.
     */
    void delete(Long id);

    /**
     * Returns a List of course-marks pairs by student id.
     *
     * @param id Id of the student.
     * @return List of results for each course.
     */
    List<SummaryDTO> getSummary(Long id);
}
