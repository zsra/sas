package hu.zsra.enaplo.service.impl;

import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.TimeTableEntity;
import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.model.user.group.Teacher;
import hu.zsra.enaplo.repository.CourseRepository;
import hu.zsra.enaplo.repository.TimeTableRepository;
import hu.zsra.enaplo.repository.user.StudentRepository;
import hu.zsra.enaplo.repository.user.TeacherRepository;
import hu.zsra.enaplo.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeTableServiceImpl implements TimeTableService {

    @Autowired
    private TimeTableRepository timeTableRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public TimeTableEntity create(TimeTableEntity timeTableEntity) {
        return timeTableRepository.save(timeTableEntity);
    }

    @Override
    public TimeTableEntity update(Long id, TimeTableEntity timeTableEntity) {
        TimeTableEntity tableEntity = timeTableRepository.getOne(id);

        tableEntity.setClassroomNumber(timeTableEntity.getClassroomNumber());
        tableEntity.setDay(timeTableEntity.getDay());
        tableEntity.setLessonNumber(timeTableEntity.getLessonNumber());
        tableEntity.setClassroom(timeTableEntity.getClassroom());

        return timeTableRepository.save(tableEntity);
    }

    @Override
    public void delete(Long id) {
        timeTableRepository.delete(timeTableRepository.getOne(id));
    }

    @Override
    public TimeTableEntity[][] getTimeTableByStudent(Long id) {
        TimeTableEntity[][] result = new TimeTableEntity[12][5];
        Student student = studentRepository.getOne(id);
        List<TimeTableEntity> timeTableEntities = getLessonsByStudent(student.getId());
        for(TimeTableEntity tableEntity : timeTableEntities) {
            result[tableEntity.getLessonNumber()][tableEntity.getDay()] = tableEntity;
        }
        return result;
    }

    @Override
    public TimeTableEntity[][] getTimeTableByTeacher(Long id) {
        TimeTableEntity[][] result = new TimeTableEntity[12][5];
        Teacher teacher = teacherRepository.getOne(id);
        List<TimeTableEntity> timeTableEntities = getLessonsByTeacher(teacher.getId());
        for(TimeTableEntity tableEntity : timeTableEntities) {
            result[tableEntity.getLessonNumber()][tableEntity.getDay()] = tableEntity;
        }
        return result;
    }

    private List<Course> getCourseByStudent(Long id) {
        List<Course> result = new ArrayList<>();
        for(Course course : courseRepository.findAll()) {
            for(Student student : course.getStudents()) {
                if(student.getId().equals(id)) {
                    result.add(course);
                }
            }
        }
        return result;
    }

    private List<TimeTableEntity> getLessonsByStudent(Long id) {
        List<Course> courses = getCourseByStudent(id);
        List<TimeTableEntity> result = new ArrayList<>();
        for(TimeTableEntity tableEntity : timeTableRepository.findAll()) {
            for(Course course : courses) {
                if(tableEntity.getCourse().getId().equals(course.getId())){
                    result.add(tableEntity);
                }
            }
        }
        return result;
    }

    private List<Course> getCourseByTeacher(Long id) {
        List<Course> result = new ArrayList<>();
        for(Course course : courseRepository.findAll()) {
            if(course.getTeacher().getId().equals(id)) {
                result.add(course);
            }
        }
        return result;
    }

    private List<TimeTableEntity> getLessonsByTeacher(Long id) {
        List<Course> courses = getCourseByTeacher(id);
        List<TimeTableEntity> result = new ArrayList<>();
        for(TimeTableEntity tableEntity : timeTableRepository.findAll()) {
            for(Course course : courses) {
                if(tableEntity.getCourse().getId().equals(course.getId())){
                    result.add(tableEntity);
                }
            }
        }
        return result;
    }

}
