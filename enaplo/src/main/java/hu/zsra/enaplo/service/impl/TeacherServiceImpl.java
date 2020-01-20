package hu.zsra.enaplo.service.impl;

import hu.zsra.enaplo.dto.TeacherResponseDTO;
import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.user.User;
import hu.zsra.enaplo.model.user.group.Teacher;
import hu.zsra.enaplo.repository.CourseRepository;
import hu.zsra.enaplo.repository.user.TeacherRepository;
import hu.zsra.enaplo.repository.user.UserRepository;
import hu.zsra.enaplo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(Long id) {
        return teacherRepository
                .findById(id).orElse(null);
    }

    @Override
    public Teacher findByUserId(Long user_id) {
        return teacherRepository
                .findAll()
                .stream()
                .filter(teacher -> teacher.getTeacher()
                        .getId().equals(user_id))
                .findAny()
                .orElse(null);
    }

    @Override
    public Teacher save(TeacherResponseDTO teacherResponseDTO) {
        User user = userRepository.findByUsername(teacherResponseDTO.getUsername());
        Teacher teacher = new Teacher();
        teacher.setEmail(teacherResponseDTO.getEmail());
        teacher.setPhone(teacherResponseDTO.getPhone());
        teacher.setTeacher(user);

        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher update(Long id, TeacherResponseDTO teacherResponseDTO) {
        User user = userRepository.findByUsername(teacherResponseDTO.getUsername());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        user = userRepository.findByUsername(teacherResponseDTO.getUsername());
        Teacher teacher = teacherRepository.getOne(id);
        teacher.setEmail(teacherResponseDTO.getEmail());
        teacher.setPhone(teacherResponseDTO.getPhone());
        teacher.setTeacher(user);

        return teacherRepository.save(teacher);
    }

    @Override
    public void setCourse(Long teacher_id, Long course_id) {
        Teacher teacher = teacherRepository.getOne(teacher_id);
        Course course = courseRepository.getOne(course_id);
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    @Override
    public void delete(Long id) {
        teacherRepository.delete(teacherRepository.getOne(id));
    }
}
