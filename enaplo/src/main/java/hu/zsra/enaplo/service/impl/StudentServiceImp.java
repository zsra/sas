package hu.zsra.enaplo.service.impl;

import hu.zsra.enaplo.dto.response.StudentResponseDTO;
import hu.zsra.enaplo.dto.SummaryDTO;
import hu.zsra.enaplo.model.Classroom;
import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.Exam;
import hu.zsra.enaplo.model.user.User;
import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.repository.ClassroomRepository;
import hu.zsra.enaplo.repository.CourseRepository;
import hu.zsra.enaplo.repository.user.StudentRepository;
import hu.zsra.enaplo.repository.user.UserRepository;
import hu.zsra.enaplo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class contains all related function implementations to the student.
 */
@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Returns a List of Students.
     *
     * @return students from database.
     */
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    /**
     * Returns a Students object by id, if classroom exist
     * or returns a null value.
     *
     * @param id Id of the student.
     * @return a student object by id.
     * @see Student
     */
    @Override
    public Student findById(Long id) {
        return studentRepository
                .findById(id).orElse(null);
    }

    /**
     * Returns a Students object by username, if classroom exist
     * or returns a null value.
     *
     * @param user_id Id of the student user.
     * @return a student object by user id.
     * @see Student
     */
    @Override
    public Student findByUserId(Long user_id) {
        return studentRepository
                .findAll()
                .stream()
                .filter(student -> student.getStudent()
                        .getId().equals(user_id))
                .findAny()
                .orElse(null);
    }

    /**
     * Creates a new student and save into the database.
     *
     * @param studentResponseDTO Submitted DTO from web application.
     * @return  a new Student object.
     * @see Student
     */
    @Override
    public Student create(StudentResponseDTO studentResponseDTO) {
        User user = userRepository.findByUsername(studentResponseDTO.getUsername());
        Classroom classroom = classroomRepository.getOne(studentResponseDTO.getClassroom_id());
        Student student = new Student();

        student.setAddress(studentResponseDTO.getAddress());
        student.setClassroom(classroom);
        student.setDateOfBirth(studentResponseDTO.getDateOfBirth());
        student.setEducationId(studentResponseDTO.getEducationId());
        student.setHealthCareId(studentResponseDTO.getHealthCareId());
        student.setStart_year(studentResponseDTO.getStart_year());
        student.setParent1Name(studentResponseDTO.getParent1Name());
        student.setParent2Name(studentResponseDTO.getParent2Name());
        student.setParent1Phone(studentResponseDTO.getParent1Phone());
        student.setParent2Phone(studentResponseDTO.getParent2Phone());
        student.setStudent(user);
        studentRepository.save(student);
        return student;
    }

    /**
     * Updates a student from database by id.
     *
     * @param id Id of the student.
     * @param studentResponseDTO Submitted DTO from web application.
     * @return an updated student.
     * @see Student
     */
    @Override
    public Student update(Long id, StudentResponseDTO studentResponseDTO) {
        Classroom classroom = classroomRepository.getOne(studentResponseDTO.getClassroom_id());
        Student student = studentRepository.getOne(id);

        student.setAddress(studentResponseDTO.getAddress());
        student.setClassroom(classroom);
        student.setDateOfBirth(studentResponseDTO.getDateOfBirth());
        student.setEducationId(studentResponseDTO.getEducationId());
        student.setHealthCareId(studentResponseDTO.getHealthCareId());
        student.setStart_year(studentResponseDTO.getStart_year());
        student.setParent1Name(studentResponseDTO.getParent1Name());
        student.setParent2Name(studentResponseDTO.getParent2Name());
        student.setParent1Phone(studentResponseDTO.getParent1Phone());
        student.setParent2Phone(studentResponseDTO.getParent2Phone());

        return studentRepository.save(student);
    }

    /**
     * Deletes a student from database by id.
     *
     * @param id Id of the student.
     */
    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    /**
     * Returns a List of course-marks pairs by student id.
     *
     * @param id Id of the student.
     * @return List of results for each course.
     */
    @Override
    public List<SummaryDTO> getSummary(Long id) {
        Student student = studentRepository.getOne(id);
        List<SummaryDTO> summaryDTOList = new ArrayList<>();
        for(Course course : courseRepository.findAll()) {
            List<Exam> exams = student.getExams()
                    .stream()
                    .filter(exam -> exam.getCourse().getId().equals(course.getId()))
                    .collect(Collectors.toList());

            double average = exams.stream().mapToDouble(Exam::getMark).average().orElse(Double.NaN);

            summaryDTOList.add(new SummaryDTO(course.getTitle(),
                    exams.stream().mapToInt(Exam::getMark).toArray(), average));

        }
        return summaryDTOList;
    }
}
