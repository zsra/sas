package hu.zsra.enaplo.service.user;

import hu.zsra.enaplo.exception.UserManagementException;
import hu.zsra.enaplo.model.user.Admin;
import hu.zsra.enaplo.model.user.Parent;
import hu.zsra.enaplo.model.user.Student;
import hu.zsra.enaplo.repository.ClassroomRepository;
import hu.zsra.enaplo.repository.user.ParentRepository;
import hu.zsra.enaplo.repository.user.StudentRepository;
import hu.zsra.enaplo.security.JwtTokenProvider;
import hu.zsra.enaplo.service.util.UniqueUsernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UniqueUsernameService uniqueUsernameService;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private ClassroomRepository classroomRepository;

    public String signIn(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, studentRepository.findByUsername(username).getRole());
        } catch (AuthenticationException e) {
            throw new UserManagementException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public String create(Student student) {
        if(uniqueUsernameService.isUnique(student.getUsername())) {
            boolean isParentsUsernameUnique = true;
            for(Parent parent : student.getParents()) {
                if(!uniqueUsernameService.isUnique(parent.getUsername()) || student.getParents().isEmpty()) {
                    isParentsUsernameUnique = false;
                }
            }
            if(isParentsUsernameUnique) {
                student.setPassword(passwordEncoder.encode(student.getPassword()));
                for(Parent parent : student.getParents()) {
                    parent.setPassword(passwordEncoder.encode(parent.getPassword()));
                    parentRepository.save(parent);
                }
                studentRepository.save(student);
                return jwtTokenProvider.createToken(student.getUsername(), student.getRole());
            }
        }
        throw new UserManagementException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public void delete(String username) {
        studentRepository.deleteByUsername(username);
    }

    public Student getStudentByUsername(String username) {
        Student student = studentRepository.findByUsername(username);
        if(student == null) {
            throw new UserManagementException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return student;
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, studentRepository.findByUsername(username).getRole());
    }
}
