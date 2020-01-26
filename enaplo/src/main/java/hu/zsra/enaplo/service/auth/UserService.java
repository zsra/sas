package hu.zsra.enaplo.service.auth;

import hu.zsra.enaplo.dto.response.UserResponseDTO;
import hu.zsra.enaplo.model.user.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    void resetCredentials(String username);
    User findById(Long id);
    User save(UserResponseDTO userResponseDTO);
    User update(Long id, UserResponseDTO userResponseDTO);
    boolean isUsernameUnique(String username);
}
