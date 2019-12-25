package hu.zsra.enaplo.service.user;

import hu.zsra.enaplo.exception.UserManagementException;
import hu.zsra.enaplo.model.user.Teacher;
import hu.zsra.enaplo.repository.user.TeacherRepository;
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
public class TeacherService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UniqueUsernameService uniqueUsernameService;

    @Autowired
    private TeacherRepository teacherRepository;

    public String signIn(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, teacherRepository.findByUsername(username).getRole());
        } catch (AuthenticationException e) {
            throw new UserManagementException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public String create(Teacher teacher) {
        if(uniqueUsernameService.isUnique(teacher.getUsername())) {
            teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
            teacherRepository.save(teacher);
            return jwtTokenProvider.createToken(teacher.getUsername(), teacher.getRole());
        } else {
            throw new UserManagementException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    public void delete(String username) {
        teacherRepository.deleteByUsername(username);
    }

    public Teacher getTeacherByUsername(String username) {
        Teacher teacher = teacherRepository.findByUsername(username);
        if(teacher == null) {
            throw new UserManagementException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return teacher;
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, teacherRepository.findByUsername(username).getRole());
    }
}
