package hu.zsra.enaplo.service;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.Lesson;
import hu.zsra.enaplo.model.user.Student;
import hu.zsra.enaplo.repository.CourseRepository;
import hu.zsra.enaplo.repository.TimeTableRepository;
import hu.zsra.enaplo.repository.user.StudentRepository;
import hu.zsra.enaplo.repository.user.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TimeTableService {

    @Autowired
    private TimeTableRepository timeTableRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public Lesson create(Lesson lesson) {
        return timeTableRepository.save(lesson);
    }

    private Lesson getById(Long id) throws ResourceNotFoundException {
        return timeTableRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found!"));
    }

    public Set<Lesson> getByStudentUsername(String username) {
        Set<Lesson> result = new HashSet<>();
        for (Lesson lesson : timeTableRepository.findAll()) {
            for(Student student : studentRepository.findAll()) {
                if(student.getUsername().equals(username)) {
                    result.add(lesson);
                }
            }
        }
        return result;
    }

    public Set<Lesson> getByTeacherUsername(String username) {
        Set<Lesson> lessons = new HashSet<>();
        for(Lesson lesson : timeTableRepository.findAll()) {
            for(Course course : courseRepository.findAll()) {
                if(lesson.getCourse().equals(course)
                        && course.getTeacher().getUsername().equals(username)) {
                    lessons.add(lesson);
                }
            }
        }
        return lessons;
    }

    public Lesson update(Long id, Lesson lesson) throws ResourceNotFoundException {
        Lesson oldLesson = getById(id);

        oldLesson.setDay(lesson.getDay());
        oldLesson.setLessonNumber(lesson.getLessonNumber());
        oldLesson.setClassroomNumber(lesson.getClassroomNumber());
        oldLesson.setCourse(lesson.getCourse());

        return timeTableRepository.save(oldLesson);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        timeTableRepository.delete(getById(id));
    }
}
