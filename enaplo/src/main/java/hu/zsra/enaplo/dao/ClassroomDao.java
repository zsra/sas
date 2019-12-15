package hu.zsra.enaplo.dao;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Classroom;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ClassroomDao {

    ResponseEntity<List<Classroom>> getAll();
    ResponseEntity<Classroom> getClassroomById() throws ResourceNotFoundException;
    Classroom save(Classroom classroom);
    ResponseEntity<Classroom> update(Long id, Classroom classroom) throws ResourceNotFoundException;
    Map<String, Boolean> delete(Long id) throws ResourceNotFoundException;
}
