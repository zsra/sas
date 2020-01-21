package hu.zsra.enaplo.service.impl;

import hu.zsra.enaplo.dto.response.TimeTableEntityResponseDTO;
import hu.zsra.enaplo.model.Classroom;
import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.TimeTableEntity;
import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.model.user.group.Teacher;
import hu.zsra.enaplo.repository.ClassroomRepository;
import hu.zsra.enaplo.repository.CourseRepository;
import hu.zsra.enaplo.repository.TimeTableRepository;
import hu.zsra.enaplo.repository.user.StudentRepository;
import hu.zsra.enaplo.repository.user.TeacherRepository;
import hu.zsra.enaplo.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains all related function implementations to the timeTableEntity.
 */
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
    @Autowired
    private ClassroomRepository classroomRepository;

    /**
     * Returns a TimeTable 2d array to student. The table size
     * is 12x5. The y diagonal represents the days and x diagonal
     * shows the lecture.
     *
     * @param id Id of the Student.
     * @return a TimeTable 2d matrix.
     */
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

    /**
     * Returns a TimeTable 2d array to teacher. The table size
     * is 12x5. The y diagonal represents the days and x diagonal
     * shows the lecture.
     *
     * @param id Id of the Teacher.
     * @return a TimeTable 2d matrix.
     */
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

    /**
     * Creates a new TimeTableEntity and save into the database.
     *
     * @param timeTableEntityResponseDTO Submitted DTO from web application.
     * @return  a new TimeTableEntity object.
     * @see TimeTableEntity
     */
    @Override
    public TimeTableEntity create(TimeTableEntityResponseDTO timeTableEntityResponseDTO) {
        /* Finds classroom by id. */
        Classroom classroom = classroomRepository.getOne(timeTableEntityResponseDTO.getClassroom_id());
        /* Finds course by id. */
        Course course = courseRepository.getOne(timeTableEntityResponseDTO.getCourse_id());

        return timeTableRepository.save(new TimeTableEntity(
                timeTableEntityResponseDTO.getDay(),
                timeTableEntityResponseDTO.getLessonNumber(),
                course,
                timeTableEntityResponseDTO.getClassroomNumber(),
                classroom
        ));
    }

    /**
     * Updates a TimeTableEntity from database by id.
     *
     * @param id Id of the TimeTableEntity.
     * @param timeTableEntityResponseDTO Submitted DTO from web application.
     * @return an updated TimeTableEntity.
     * @see TimeTableEntity
     */
    @Override
    public TimeTableEntity update(Long id, TimeTableEntityResponseDTO timeTableEntityResponseDTO) {
        /* Finds timeTableEntity by id. */
        TimeTableEntity tableEntity = timeTableRepository.getOne(id);
        /* Finds classroom by id. */
        Classroom classroom = classroomRepository.getOne(timeTableEntityResponseDTO.getClassroom_id());

        tableEntity.setClassroomNumber(timeTableEntityResponseDTO.getClassroomNumber());
        tableEntity.setDay(timeTableEntityResponseDTO.getDay());
        tableEntity.setLessonNumber(timeTableEntityResponseDTO.getLessonNumber());
        tableEntity.setClassroom(classroom);

        return timeTableRepository.save(tableEntity);
    }

    /**
     * Deletes a TimeTableEntity from database by id.
     *
     * @param id Id of the TimeTableEntity.
     */
    @Override
    public void delete(Long id) {
        timeTableRepository.delete(timeTableRepository.getOne(id));
    }

    /**
     * Returns a List of Courses that Student has.
     *
     * @param id Id of the Student.
     * @return List of course.
     */
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

    /**
     * Returns a List of TimeTableEntity. Each element
     * represents a lecture.
     *
     * @param id Id of the Student.
     * @return List of timeTableEntity.
     */
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

    /**
     * Returns a List of Courses that Teacher has.
     *
     * @param id Id of the Teacher.
     * @return List of course.
     */
    private List<Course> getCourseByTeacher(Long id) {
        List<Course> result = new ArrayList<>();
        for(Course course : courseRepository.findAll()) {
            if(course.getTeacher().getId().equals(id)) {
                result.add(course);
            }
        }
        return result;
    }

    /**
     * Returns a List of TimeTableEntity. Each element
     * represents a lecture.
     *
     * @param id Id of the Teacher.
     * @return List of timeTableEntity.
     */
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
