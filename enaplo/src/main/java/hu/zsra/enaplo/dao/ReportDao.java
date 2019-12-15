package hu.zsra.enaplo.dao;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.report.Report;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ReportDao {

    ResponseEntity<List<Report>> getAll();
    ResponseEntity<Report> getReportById() throws ResourceNotFoundException;
    Report save(Report report);
    ResponseEntity<Report> update(Long id, Report report) throws ResourceNotFoundException;
    Map<String, Boolean> delete(Long id) throws ResourceNotFoundException;
}
