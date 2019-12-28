package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Report;
import hu.zsra.enaplo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/create")
    public Report create(@RequestBody Report report) {
        return reportService.create(report);
    }

    @GetMapping("/{id}")
    public Report getById(@PathVariable Long id) throws ResourceNotFoundException {
        return reportService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Report update(@PathVariable Long id,
                         @Valid @RequestBody Report report) throws ResourceNotFoundException {
        return reportService.update(id, report);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) throws ResourceNotFoundException {
        reportService.delete(id);
        return id.toString();
    }
}
