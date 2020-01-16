package hu.zsra.enaplo.service;

import hu.zsra.enaplo.model.Report;

public interface ReportService {

    Report create(Report report);
    Report update(Long id, Report report);
    void delete(Long id);
}
