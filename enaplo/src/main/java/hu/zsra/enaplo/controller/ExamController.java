package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.ExamDTO;
import hu.zsra.enaplo.dto.response.ExamResponseDTO;
import hu.zsra.enaplo.model.Exam;
import hu.zsra.enaplo.service.impl.ExamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/api")
public class ExamController {

    @Autowired
    private ExamServiceImpl examService;

    @PostMapping(value = "/exams/student/{student_id}")
    public List<Exam> findAllByStudent(@PathVariable Long student_id,
                                       @RequestBody Long course_id) {
        return examService.findAllByStudent(student_id, course_id);
    }

    @GetMapping(value = "/exams/{id}")
    public Exam findById(@PathVariable Long id) {
        return examService.findById(id);
    }

    @PostMapping(value = "/exams/create")
    public Exam create(@RequestBody ExamResponseDTO examResponseDTO) {
        return examService.create(examResponseDTO);
    }

    @PutMapping(value = "/exams/update/{id}")
        public Exam update(@PathVariable Long id,
                       @RequestBody ExamResponseDTO examResponseDTO) {
        return examService.update(id, examResponseDTO);
    }

    @DeleteMapping(value = "/exams/{id}")
    public String delete(@PathVariable Long id) {
        examService.delete(id);
        return id.toString();
    }

    @PostMapping(value = "/exams/form/{classroom_id}")
    public List<ExamDTO> makeExamsFormToClassroom(@PathVariable Long classroom_id,
                                                  @RequestBody String written_at) {
        return examService.makeExamsFormToClassroom(classroom_id,LocalDate.parse(written_at));
    }

    @PostMapping(value = "/exams/form/create")
    public List<Exam> createExamsFromForm(@RequestBody List<ExamResponseDTO> examResponseDTOS) {
        return examService.createExamsFromForm(examResponseDTOS);
    }
}
