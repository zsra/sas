package hu.zsra.enaplo.service.auth.impl;

import hu.zsra.enaplo.dto.response.UserResponseDTO;
import hu.zsra.enaplo.exception.CustomException;
import hu.zsra.enaplo.model.user.Authority;
import hu.zsra.enaplo.model.user.User;
import hu.zsra.enaplo.repository.user.UserRepository;
import hu.zsra.enaplo.service.auth.AuthorityService;
import hu.zsra.enaplo.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authService;

    @Override
    public User save(UserResponseDTO userResponseDTO) {
        if(!userRepository.existsByUsername(userResponseDTO.getUsername())) {
            User newUser = new User();
            newUser.setUsername(userResponseDTO.getUsername());
            newUser.setPassword(passwordEncoder.encode(userResponseDTO.getPassword()));
            newUser.setFullName(userResponseDTO.getFullName());
            List<Authority> authorities = authService.findByName(userResponseDTO.getRole());
            newUser.setAuthorities(authorities);
            userRepository.save(newUser);
            return newUser;
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public User update(Long id, UserResponseDTO userResponseDTO) {
        User user = userRepository.getOne(id);

        if(!userRepository.existsByUsername(userResponseDTO.getUsername())){
            user.setUsername(userResponseDTO.getUsername());
            if(userResponseDTO.getPassword() != null) {
                user.setPassword(passwordEncoder.encode(userResponseDTO.getPassword()));
            }
            user.setFullName(userResponseDTO.getFullName());
            userRepository.save(user);
            return user;
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public String delete(Long user_id) {
        User user = userRepository.getOne(user_id);
        userRepository.delete(user);
        return user.getUsername();
    }

    @Override
    public boolean isUsernameUnique(String username) {
        return !userRepository.existsByUsername(username);
    }

    @Override
    public void resetCredentials(String username) {
        User user = userRepository.findByUsername(username);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository
                .findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


}
