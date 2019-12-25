package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.SummaryDTO;
import hu.zsra.enaplo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private RecordService recordService;

    @GetMapping("/{username}/summary")
    public Set<SummaryDTO> summary(@PathVariable String username) {
        return recordService.getSummary(username);
    }
}
