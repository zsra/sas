package hu.zsra.enaplo.dao.user;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.user.Parent;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ParentDao {

    ResponseEntity<List<Parent>> getAll();
    ResponseEntity<Parent> getParentById() throws ResourceNotFoundException;
    Parent save(Parent parent);
    ResponseEntity<Parent> update(Long id, Parent parent) throws ResourceNotFoundException;
    Map<String, Boolean> delete(Long id) throws ResourceNotFoundException;
}
