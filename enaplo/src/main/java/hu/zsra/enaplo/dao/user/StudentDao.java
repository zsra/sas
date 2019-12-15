package hu.zsra.enaplo.dao.user;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.user.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    ResponseEntity<List<Student>> getAll();
    ResponseEntity<Student> getStudentById() throws ResourceNotFoundException;
    Student save(Student student);
    ResponseEntity<Student> update(Long id, Student student) throws ResourceNotFoundException;
    Map<String, Boolean> delete(Long id) throws ResourceNotFoundException;
}
