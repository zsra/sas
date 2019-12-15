package hu.zsra.enaplo.dao.user;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.user.Teacher;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface TeacherDao {

    ResponseEntity<List<Teacher>> getAll();
    ResponseEntity<Teacher> getTeacherById() throws ResourceNotFoundException;
    Teacher save(Teacher teacher);
    ResponseEntity<Teacher> update(Long id, Teacher teacher) throws ResourceNotFoundException;
    Map<String, Boolean> delete(Long id) throws ResourceNotFoundException;
}
