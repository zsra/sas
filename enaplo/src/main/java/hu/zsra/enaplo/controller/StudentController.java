package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.StudentResponseDTO;
import hu.zsra.enaplo.dto.SummaryDTO;
import hu.zsra.enaplo.model.user.User;
import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.service.impl.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class StudentController {

    @Autowired
    private StudentServiceImp studentService;

    @GetMapping(value = "/students/all")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping(value = "/students/{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @GetMapping(value = "/students/user/{user_id}")
    public Student findByUserId(@PathVariable Long user_id) {
        return studentService.findByUserId(user_id);
    }

    @PostMapping(value = "/students/create")
    public ResponseEntity<?> save(@RequestBody StudentResponseDTO studentResponseDTO,
                                  UriComponentsBuilder ucBuilder) {
        Student student = studentService.save(studentResponseDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(student.getId()).toUri());
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }

    @PutMapping(value = "/students/update/{id}")
    public Student update(@PathVariable Long id,
                          @RequestBody StudentResponseDTO studentResponseDTO) {
        return studentService.update(id, studentResponseDTO);
    }

    @DeleteMapping(value = "/students/{id}")
    public String delete(@PathVariable Long id) {
        studentService.delete(id);
        return id.toString();
    }

    @GetMapping("/students/summary/{id}")
    public List<SummaryDTO> summary(@PathVariable Long id) {
        return studentService.getSummary(id);
    }
}
