package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.ReportDTO;
import hu.zsra.enaplo.dto.response.ReportResponseDTO;
import hu.zsra.enaplo.model.Report;
import hu.zsra.enaplo.service.impl.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ReportController {

    @Autowired
    private ReportServiceImpl reportService;

    @PostMapping(value = "/reports/{student_id}/{year}")
    public List<Report> getSemesterResultByStudent(@PathVariable Long student_id,
                                                   @PathVariable int year, @RequestBody int semester) {
        return reportService.getSemesterResultByStudent(student_id, year, semester);
    }

    @GetMapping(value = "/reports/{id}")
    public Report findById(@PathVariable Long id) {
        return reportService.findById(id);
    }

    @PostMapping(value = "/reports/create")
    public Report create(@RequestBody ReportResponseDTO reportResponseDTO) {
        return reportService.create(reportResponseDTO);
    }

    @PutMapping(value = "/reports/update/{id}")
    public Report update(@PathVariable Long id,
                         @RequestBody ReportResponseDTO reportResponseDTO) {
        return reportService.update(id, reportResponseDTO);
    }

    @DeleteMapping(value = "/reports/{id}")
    public String delete(@PathVariable Long id) {
        reportService.delete(id);
        return id.toString();
    }

    @GetMapping(value = "/reports/form/{classroom_id}")
    public List<ReportDTO> makeReportFormToClassroom(@PathVariable Long classroom_id){
        return reportService.makeReportFormToClassroom(classroom_id);
    }

    @PostMapping(value = "/reports/form/create")
    public List<Report> createReportsToClassroom(@RequestBody List<ReportResponseDTO> reportResponseDTOS) {
        return reportService.createReportsToClassroom(reportResponseDTOS);
    }
}
