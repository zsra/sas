package hu.zsra.enaplo.service.auth;

import hu.zsra.enaplo.dto.UserResponseDTO;
import hu.zsra.enaplo.model.user.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    void resetCredentials(String username);
    User findById(Long id);
    User findByUsername(String username);
    User save(UserResponseDTO user);
}
