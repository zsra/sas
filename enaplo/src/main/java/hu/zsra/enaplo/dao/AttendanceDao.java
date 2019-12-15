package hu.zsra.enaplo.dao;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Attendance;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface AttendanceDao {

    ResponseEntity<List<Attendance>> getAll();
    ResponseEntity<ClassroomDao> getAttendanceById() throws ResourceNotFoundException;
    Attendance save(Attendance attendance);
    ResponseEntity<Attendance> update(Long id, Attendance attendance) throws ResourceNotFoundException;
    Map<String, Boolean> delete(Long id) throws ResourceNotFoundException;
}
