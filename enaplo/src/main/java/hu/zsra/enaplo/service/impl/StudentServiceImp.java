package hu.zsra.enaplo.service.impl;

import hu.zsra.enaplo.dto.StudentResponseDTO;
import hu.zsra.enaplo.dto.SummaryDTO;
import hu.zsra.enaplo.exception.ResourceNotFoundException;
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

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) throws ResourceNotFoundException {
        return studentRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found!"));
    }

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

    @Override
    public Student save(StudentResponseDTO studentResponseDTO) {
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
        student.setStudent(user);
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student update(Long id, StudentResponseDTO studentResponseDTO) {

        User user = userRepository.findByUsername(studentResponseDTO.getUsername());
        user.setFullName(studentResponseDTO.getFullName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        user = userRepository.findByUsername(studentResponseDTO.getUsername());
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


        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<SummaryDTO> getSummary(Long id) throws ResourceNotFoundException {
        Student student = findById(id);
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
