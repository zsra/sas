package hu.zsra.enaplo.service.util;

import hu.zsra.enaplo.repository.user.AdminRepository;
import hu.zsra.enaplo.repository.user.ParentRepository;
import hu.zsra.enaplo.repository.user.StudentRepository;
import hu.zsra.enaplo.repository.user.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniqueUsernameService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ParentRepository parentRepository;

    public boolean isUnique(String username) {
        return !(adminRepository.existsByUsername(username)
                || studentRepository.existsByUsername(username)
                || teacherRepository.existsByUsername(username)
                || parentRepository.existsByUsername(username));
    }
}
