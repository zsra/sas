package hu.zsra.enaplo.security;

import hu.zsra.enaplo.model.user.*;
import hu.zsra.enaplo.repository.user.AdminRepository;
import hu.zsra.enaplo.repository.user.ParentRepository;
import hu.zsra.enaplo.repository.user.StudentRepository;
import hu.zsra.enaplo.repository.user.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static hu.zsra.enaplo.model.user.Role.*;

@Service
public class UserDetails implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (getUserRole(username) == ROLE_ADMIN) {
            final Admin admin = adminRepository.findByUsername(username);
            return getUserDetails(admin, username);
        }
        else if(getUserRole(username) == ROLE_STUDENT) {
            final Student student = studentRepository.findByUsername(username);
            return getUserDetails(student, username);
        }
        else if(getUserRole(username) == ROLE_PARENT){
            final Parent parent = parentRepository.findByUsername(username);
            return getUserDetails(parent, username);
        } else {
            final Teacher teacher = teacherRepository.findByUsername(username);
            return getUserDetails(teacher, username);
        }
    }

    private Role getUserRole(String username) {
        if(adminRepository.existsByUsername(username)) {
            return ROLE_ADMIN;
        }
        else if(teacherRepository.existsByUsername(username)) {
            return Role.ROLE_TEACHER;
        }
        else if(studentRepository.existsByUsername(username)) {
            return Role.ROLE_STUDENT;
        }else if(parentRepository.existsByUsername(username)) {
            return ROLE_PARENT;
        } else {
            throw new UsernameNotFoundException(" '"+ username + "' not found.");
        }
    }

    private <T extends hu.zsra.enaplo.model.user.User> org.springframework.security
            .core.userdetails.UserDetails getUserDetails(T user, String username) {
        return User
                .withUsername(username)
                .password(user.getPassword())
                .authorities(user.getRole())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}