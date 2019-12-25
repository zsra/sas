package hu.zsra.enaplo.service.user;

import hu.zsra.enaplo.exception.UserManagementException;
import hu.zsra.enaplo.model.user.Admin;
import hu.zsra.enaplo.repository.user.AdminRepository;
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
public class AdminService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UniqueUsernameService uniqueUsernameService;

    @Autowired
    private AdminRepository adminRepository;

    public String signIn(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, adminRepository.findByUsername(username).getRole());
        } catch (AuthenticationException e) {
            throw new UserManagementException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public String create(Admin admin) {
        if(uniqueUsernameService.isUnique(admin.getUsername())) {
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            adminRepository.save(admin);
            return jwtTokenProvider.createToken(admin.getUsername(), admin.getRole());
        } else {
            throw new UserManagementException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    public void delete(String username) {
        adminRepository.deleteByUsername(username);
    }

    public Admin getAdminByUsername(String username) {
        Admin admin = adminRepository.findByUsername(username);
        if(admin == null) {
            throw new UserManagementException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return admin;
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, adminRepository.findByUsername(username).getRole());
    }
}
