package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.model.Report;
import hu.zsra.enaplo.service.impl.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class ReportController {

    @Autowired
    private ReportServiceImpl reportService;

    @PostMapping(value = "/reports/create")
    public Report create(@RequestBody Report report) {
        return reportService.create(report);
    }

    @PutMapping(value = "/reports/update/{id}")
    public Report update(@PathVariable Long id,
                         @Valid @RequestBody Report report) {
        return reportService.update(id, report);
    }

    @DeleteMapping(value = "/reports/{id}")
    public String delete(@PathVariable Long id) {
        reportService.delete(id);
        return id.toString();
    }
}
