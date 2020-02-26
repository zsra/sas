package hu.zsra.enaplo.service.impl;

import hu.zsra.enaplo.dto.ClassroomCourseResultDTO;
import hu.zsra.enaplo.dto.FailedStudentDTO;
import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.Exam;
import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.repository.ClassroomRepository;
import hu.zsra.enaplo.repository.CourseRepository;
import hu.zsra.enaplo.repository.ExamRepository;
import hu.zsra.enaplo.repository.user.StudentRepository;
import hu.zsra.enaplo.service.HeadTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class contains all related function implementations to the headteacher.
 */
@Service
public class HeadTeacherServiceImpl implements HeadTeacherService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;


    /**
     * Find all student who failed at least one subject.
     *
     * @param classroom_id Id of the class.
     * @return List of Failed Student with courses.
     */
    @Override
    public List<FailedStudentDTO> findFailedStudentsInClass(Long classroom_id) {
        List<FailedStudentDTO> result = new ArrayList<>();
        List<Student> students = getStudentsFromClassroom(classroom_id);
        for(Student student: students) {
            List<Course> failedCourses = new ArrayList<>();
            for(Course course : courseRepository.findAll()) {
                if(student.getCourses().contains(course)) {
                    double avg = calcAverageByStudent(student, course.getId());
                    if(avg < 2 && avg >= 1) {
                        failedCourses.add(course);
                    }
                }
            }
            if(!failedCourses.isEmpty()) {
                result.add(new FailedStudentDTO(
                        student,
                        failedCourses
                ));
            }
        }
        return result;
    }

    /**
     * Returns a list of ClassroomCourseResultDTO. This function create an
     * average for each course by class id.
     *
     * @param classroom_id Id of the class.
     * @return List of ClassroomCourseResultDTO by classroom id.
     */
    @Override
    public List<ClassroomCourseResultDTO> showResultByCourse(Long classroom_id) {
        List<ClassroomCourseResultDTO> result = new ArrayList<>();
        List<Student> students = getStudentsFromClassroom(classroom_id);
        List<Long> courses = new ArrayList<>();
        for(Student student: students) {
            for(Course course : courseRepository.findAll()) {
                if(student.getCourses().contains(course) && !courses.contains(course.getId())) {
                    result.add(new ClassroomCourseResultDTO(
                            course,
                            collectResultByCourse(classroom_id, course.getId())
                    ));
                    courses.add(course.getId());
                }
            }
        }
        return result;
    }

    private List<Student> getStudentsFromClassroom(Long id) {
        return studentRepository
                .findAll()
                .stream()
                .filter(student -> student.getClassroom().getId().equals(id))
                .collect(Collectors.toList());
    }

    private double collectResultByCourse(Long classroom_id, Long course_id) {
        List<Double> result = new ArrayList<>();
        List<Student> students = getStudentsFromClassroom(classroom_id);
        for(Student student: students) {
            result.add(calcAverageByStudent(student, course_id));
        }
        return result.stream().mapToDouble(Double::doubleValue).average().orElse(Double.NaN);
    }

    private double calcAverageByStudent(Student student, Long course_id) {
        List<Exam> exams = student.getExams()
                .stream()
                .filter(exam -> exam.getCourse().getId().equals(course_id))
                .collect(Collectors.toList());
        return exams.stream().mapToDouble(Exam::getMark).average().orElse(Double.NaN);
    }
}
