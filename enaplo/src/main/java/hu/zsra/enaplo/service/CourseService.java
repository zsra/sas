package hu.zsra.enaplo.service;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course create(Course course) {
        return courseRepository.save(course);
    }

    public Course getById(Long id) throws ResourceNotFoundException {
        return courseRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found!"));
    }

    public Set<Course> getAll() {
        return new HashSet<>(courseRepository.findAll());
    }

    public void delete(Long id) throws ResourceNotFoundException {
        Course course = courseRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found!"));
        courseRepository.delete(course);
    }

    public Course update(Long id, Course course) throws ResourceNotFoundException {
        Course oldCourse = courseRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found!"));

        oldCourse.setDescription(course.getDescription());
        oldCourse.setTeacher(course.getTeacher());
        oldCourse.setTitle(course.getTitle());

        return courseRepository.save(oldCourse);
    }
}
