package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.exam.Exam;
import hu.zsra.enaplo.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Service
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping("/create")
    public Exam create(@RequestBody Exam exam) {
        return  examService.create(exam);
    }

    @GetMapping("/update/{id}")
    public Exam update(@PathVariable Long id,
                       @Valid @RequestBody Exam exam) throws ResourceNotFoundException {
        return examService.update(id, exam);
    }

    @GetMapping("/{id}")
    public Exam getById(@PathVariable Long id) throws ResourceNotFoundException {
        return examService.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) throws ResourceNotFoundException {
        examService.delete(id);
        return id.toString();
    }
}
