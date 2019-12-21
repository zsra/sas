package hu.zsra.enaplo.service;

import hu.zsra.enaplo.exception.InvalidSignInException;
import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.exception.UsernameException;
import hu.zsra.enaplo.model.user.User;
import hu.zsra.enaplo.repository.user.UserRepository;
import hu.zsra.enaplo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String signIn(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRole());
        } catch (AuthenticationException e) {
            throw new InvalidSignInException();
        }
    }

    public String signUp(User user) {
        if(!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return jwtTokenProvider.createToken(user.getUsername(), user.getRole());
        } else {
            throw new UsernameException();
        }
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }

    public User search(String username) throws ResourceNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new ResourceNotFoundException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return user;
    }

    public User whoAmI(HttpServletRequest httpServletRequest) {
        return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(httpServletRequest)));
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRole());
    }
}
