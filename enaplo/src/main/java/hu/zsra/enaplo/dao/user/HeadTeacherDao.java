package hu.zsra.enaplo.dao.user;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.user.HeadTeacher;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface HeadTeacherDao {

    ResponseEntity<List<HeadTeacher>> getAll();
    ResponseEntity<HeadTeacher> getHeadTeacherById() throws ResourceNotFoundException;
    HeadTeacher save(HeadTeacher headTeacher);
    ResponseEntity<HeadTeacher> update(Long id, HeadTeacher headTeacher) throws ResourceNotFoundException;
    Map<String, Boolean> delete(Long id) throws ResourceNotFoundException;
}
