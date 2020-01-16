package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.model.Exam;
import hu.zsra.enaplo.service.impl.ExamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class ExamController {

    @Autowired
    private ExamServiceImpl examService;

    @PostMapping(value = "/exams/create")
    public Exam create(@RequestBody Exam exam) {
        return examService.create(exam);
    }

    @PutMapping(value = "/exams/update/{id}")
    public Exam update(@PathVariable Long id,
                       @Valid @RequestBody Exam exam) {
        return examService.update(id, exam);
    }

    @DeleteMapping(value = "/exams/{id}")
    public String delete(@PathVariable Long id) {
        examService.delete(id);
        return id.toString();
    }
}
