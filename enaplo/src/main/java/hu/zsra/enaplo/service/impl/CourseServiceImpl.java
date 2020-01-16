package hu.zsra.enaplo.service.impl;

import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.repository.CourseRepository;
import hu.zsra.enaplo.repository.user.StudentRepository;
import hu.zsra.enaplo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Course create(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Long id, Course course) {
        Course oldCourse = courseRepository.getOne(id);
        oldCourse.setTeacher(course.getTeacher());
        oldCourse.setTitle(course.getTitle());
        oldCourse.setYear(course.getYear());

        return courseRepository.save(oldCourse);
    }

    @Override
    public void delete(Long id) {
        courseRepository.delete(courseRepository.getOne(id));
    }

    @Override
    public void setCourse(Long student_id, Long course_id) {
        Student student = studentRepository.getOne(student_id);
        Course course = courseRepository.getOne(course_id);
        course.getStudents().add(student);
        courseRepository.save(course);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
