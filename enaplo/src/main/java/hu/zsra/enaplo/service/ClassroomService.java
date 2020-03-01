package hu.zsra.enaplo.service;

import hu.zsra.enaplo.dto.response.ClassroomResponseDTO;
import hu.zsra.enaplo.model.Classroom;
import hu.zsra.enaplo.model.user.group.Student;

import java.util.List;

/**
 * This interface contains all related function definitions to the classroom.
 */
public interface ClassroomService {

    /**
     * Returns a List of Classroom.
     *
     * @return classrooms from database.
     */
    List<Classroom> findAll();

    /**
     * Returns a Classroom object by id, if classroom exist
     * or returns a null value.
     *
     * @param id Id of the classroom.
     * @return a classroom object by id.
     * @see Classroom
     */
    Classroom findById(Long id);

    /**
     * Returns a Classroom object by Headteacher Id if classroom exist
     * or returns a null value.
     *
     * @param id Id of the headteacher
     * @return a classroom object by headteacher id.
     */
    Classroom findByHeadteacher(Long id);

    /**
     * Creates a new classroom and save into the database.
     *
     * @param classroomResponseDTO Submitted DTO from web application.
     * @return  a new Classroom object.
     * @see Classroom
     */
    Classroom create(ClassroomResponseDTO classroomResponseDTO);

    /**
     * Updates a classroom from database by id.
     *
     * @param id Id of the classroom.
     * @param classroomResponseDTO Submitted DTO from web application.
     * @return an updated classroom.
     * @see Classroom
     */
    Classroom update(Long id, ClassroomResponseDTO classroomResponseDTO);

    /**
     * Deletes a classroom from database by id.
     *
      * @param id Id of the classroom.
     */
    void delete(Long id);

    /**
     * Returns a List of Students, who are in the class.
     *
     * @param id Id of the classroom.
     * @return List of students.
     */
    List<Student> getStudentsFromClassroom(Long id);

    /**
     * Sets a course to all student, who are in the class. This
     * method helps to update at a new year.
     *
     * @param classroom_id Id of the classroom.
     * @param course_id Id of the Course.
     */
    void setCourse(Long classroom_id, Long course_id);

    /**
     * unsets a course to all student, who are in the class.
     *
     * @param classroom_id Id of the classroom.
     * @param course_id Id of the Course.
     */
    void unsetCourse(Long classroom_id, Long course_id);

}
