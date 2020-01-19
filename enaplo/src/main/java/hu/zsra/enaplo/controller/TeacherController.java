package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.TeacherResponseDTO;
import hu.zsra.enaplo.model.user.group.Teacher;
import hu.zsra.enaplo.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;

    @GetMapping(value = "/teachers/create")
    public List<Teacher> findAll() {
        return teacherService.findAll();
    }

    @GetMapping(value = "/teachers/{id}")
    public Teacher findById(@PathVariable Long id) {
        return teacherService.findById(id);
    }

    @GetMapping(value = "/teachers/user/{user_id}")
    public Teacher findByUserId(@PathVariable Long user_id) {
        return teacherService.findByUserId(user_id);
    }

    @PostMapping(value = "/teachers/create")
    public Teacher save(@RequestBody TeacherResponseDTO teacherResponseDTO) {
        return teacherService.save(teacherResponseDTO);
    }

    @PutMapping(value = "/teachers/update/{id}")
    public Teacher update(@PathVariable Long id,
                          @RequestBody TeacherResponseDTO teacherResponseDTO) {
        return teacherService.update(id, teacherResponseDTO);
    }

    @PutMapping(value = "/teachers/setCourse/{teacher_id}")
    public String setCourse(@PathVariable Long teacher_id,
                            @RequestBody Long course_id) {
        teacherService.setCourse(teacher_id, course_id);
        return course_id.toString();
    }

    @DeleteMapping(value = "/teachers/{id}")
    public String delete(@PathVariable Long id) {
        teacherService.delete(id);
        return id.toString();
    }
}
