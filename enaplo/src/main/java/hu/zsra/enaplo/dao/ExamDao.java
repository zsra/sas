package hu.zsra.enaplo.dao;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Exam;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ExamDao {

    ResponseEntity<List<Exam>> getAll();
    ResponseEntity<Exam> getExamById() throws ResourceNotFoundException;
    Exam save(Exam exam);
    ResponseEntity<Exam> update(Long id, Exam exam) throws ResourceNotFoundException;
    Map<String, Boolean> delete(Long id) throws ResourceNotFoundException;
}
