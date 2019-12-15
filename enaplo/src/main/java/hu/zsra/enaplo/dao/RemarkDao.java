package hu.zsra.enaplo.dao;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Remark;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface RemarkDao {

    ResponseEntity<List<Remark>> getAll();
    ResponseEntity<Remark> getRemarkById() throws ResourceNotFoundException;
    Remark save(Remark remark);
    ResponseEntity<Remark> update(Long id, Remark remark) throws ResourceNotFoundException;
    Map<String, Boolean> delete(Long id) throws ResourceNotFoundException;
}
