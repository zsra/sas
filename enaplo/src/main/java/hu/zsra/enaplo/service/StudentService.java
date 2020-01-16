package hu.zsra.enaplo.service;

import hu.zsra.enaplo.dto.StudentResponseDTO;
import hu.zsra.enaplo.dto.SummaryDTO;
import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.user.group.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();
    Student findById(Long id) throws ResourceNotFoundException;
    Student findByUserId(Long user_id);
    Student save(StudentResponseDTO studentResponseDTO);
    Student update(Long id, StudentResponseDTO studentResponseDTO);
    void delete(Long id);
    List<SummaryDTO> getSummary(Long id) throws ResourceNotFoundException;
}
