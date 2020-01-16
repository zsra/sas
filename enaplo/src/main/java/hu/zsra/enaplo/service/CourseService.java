package hu.zsra.enaplo.service;

import hu.zsra.enaplo.model.Course;

import java.util.List;

public interface CourseService {

    Course create(Course course);
    Course update(Long id, Course course);
    void delete(Long id);
    void setCourse(Long student_id, Long course_id);
    List<Course> findAll();
}
