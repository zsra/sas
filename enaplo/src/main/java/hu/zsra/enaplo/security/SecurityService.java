package hu.zsra.enaplo.security;

import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.model.user.group.Teacher;
import hu.zsra.enaplo.repository.user.StudentRepository;
import hu.zsra.enaplo.repository.user.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    public boolean hasStudentAccess(Long currentUser_id, Long student_id) {
        Student student = studentRepository.getOne(student_id);
        return student.getStudent().getId().equals(currentUser_id);
    }

    public boolean hasTeacherAccess(Long currentUser_id, Long teacher_id) {
        Teacher teacher = teacherRepository.getOne(teacher_id);
        return teacher.getTeacher().getId().equals(currentUser_id);
    }
}
