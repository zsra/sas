package hu.zsra.enaplo.dao;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Course;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface CourseDao {

    ResponseEntity<List<Course>> getAll();
    ResponseEntity<Course> getCourseById() throws ResourceNotFoundException;
    Course save(Course course);
    ResponseEntity<Course> update(Long id, Course course) throws ResourceNotFoundException;
    Map<String, Boolean> delete(Long id) throws ResourceNotFoundException;
}
