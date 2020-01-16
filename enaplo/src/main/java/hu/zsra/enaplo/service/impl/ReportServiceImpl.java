package hu.zsra.enaplo.service.impl;

import hu.zsra.enaplo.model.Report;
import hu.zsra.enaplo.repository.ReportRepository;
import hu.zsra.enaplo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Report create(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public Report update(Long id, Report report) {
        Report oldReport = reportRepository.getOne(id);

        oldReport.setMark(report.getMark());
        oldReport.setSemester(report.getSemester());
        oldReport.setYear(report.getYear());
        oldReport.setCourseName(oldReport.getCourseName());
        return reportRepository.save(oldReport);
    }

    @Override
    public void delete(Long id) {
        reportRepository.delete(reportRepository.getOne(id));
    }
}
