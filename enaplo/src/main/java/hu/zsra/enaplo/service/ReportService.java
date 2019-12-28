package hu.zsra.enaplo.service;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Report;
import hu.zsra.enaplo.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public Report create(Report report) {
        return reportRepository.save(report);
    }

    public Report getById(Long id) throws ResourceNotFoundException {
        return reportRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found!"));
    }

    public Set<Report> getReports(String username, int year, int semester) {
        return reportRepository.findAll()
                .stream()
                .filter(report -> report.getStudent().getUsername().equals(username)
                && report.getYear() == year && report.getSemester() == semester)
                .collect(Collectors.toSet());
    }

    public Report update(Long id, Report report) throws ResourceNotFoundException {
        Report oldReport = getById(id);

        oldReport.setCourseName(report.getCourseName());
        oldReport.setMark(report.getMark());
        oldReport.setSemester(report.getSemester());
        oldReport.setYear(report.getYear());

        return reportRepository.save(oldReport);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        reportRepository.delete(getById(id));
    }
}
