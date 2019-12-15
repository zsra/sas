package hu.zsra.enaplo.dao.user;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.user.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserDao {

    ResponseEntity<List<User>> getAll();
    ResponseEntity<User> getUserById() throws ResourceNotFoundException;
    User save(User user);
    ResponseEntity<User> update(Long id, User user) throws ResourceNotFoundException;
    Map<String, Boolean> delete(Long id) throws ResourceNotFoundException;
}
