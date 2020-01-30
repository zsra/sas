package hu.zsra.enaplo.service;

import hu.zsra.enaplo.dto.response.CourseResponseDTO;
import hu.zsra.enaplo.model.Course;

import java.util.List;

/**
 * This interface contains all related function definitions to the course.
 */
public interface CourseService {

    /**
     * Returns a List of Courses.
     *
     * @return courses from database.
     */
    List<Course> findAll();

    /**
     * Returns a Course object by id, if course exist
     * or returns a null value.
     *
     * @param id Id of the course.
     * @return a course object by id.
     * @see Course
     */
    Course findById(Long id);

    /**
     * Returns a List of Courses by Teacher id.
     *
     * @param teacher_id Id of the Teacher.
     * @return a list of courses.
     */
    List<Course> getCoursesByTeacherId(Long teacher_id);

    /**
     * Creates a new course and save into the database.
     *
     * @param courseResponseDTO Submitted DTO from web application.
     * @return  a new Course object.
     * @see Course
     */
    Course create(CourseResponseDTO courseResponseDTO);

    /**
     * Updates a course from database by id.
     *
     * @param id Id of the course.
     * @param courseResponseDTO Submitted DTO from web application.
     * @return an updated course.
     * @see Course
     */
    Course update(Long id, CourseResponseDTO courseResponseDTO);

    /**
     * Deletes a course from database by id.
     *
     * @param id Id of the course.
     */
    void delete(Long id);

    /**
     * Sets a course to student by ids.
     *
     * @param student_id Id of the Student.
     * @param course_id Id of the Course.
     */
    void setCourse(Long student_id, Long course_id);

}
