package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Classroom;
import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.service.impl.ClassroomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ClassroomController {

    @Autowired
    private ClassroomServiceImpl classroomService;

    @GetMapping(value = "/classrooms/all")
    public List<Classroom> getAll() {
        return classroomService.getAll();
    }

    @PostMapping(value = "/classrooms/create")
    public Classroom create(@RequestBody Classroom classroom) {
        return classroomService.create(classroom);
    }

    @PutMapping(value = "/classroomsupdate/{id}")
    public Classroom update(@PathVariable Long id,
                            @Valid @RequestBody Classroom classroom) throws ResourceNotFoundException {
        return classroomService.update(id, classroom);
    }

    @DeleteMapping(value = "/classrooms/{id}")
    public String delete(Long id) {
        classroomService.delete(id);
        return id.toString();
    }

    @GetMapping(value = "/classrooms/teacher/{id}")
    public Classroom getByHeadTeacher(@PathVariable Long id) {
        return classroomService.getByHeadTeacher(id);
    }

    @GetMapping(value = "/classrooms/students/{id}")
    public List<Student> getStudentsFromClassroom(@PathVariable Long id) {
        return classroomService.getStudentsFromClassroom(id);
    }

    @PutMapping(value = "/classrooms/setCourse/{id}")
    public String setCourse(@PathVariable Long classroom_id,
                            @RequestBody Long course_id) {
        classroomService.setCourse(classroom_id, course_id);
        return course_id.toString();
    }

    @GetMapping(value = "/classrooms/{id}")
    public Classroom getById(Long id) throws ResourceNotFoundException {
        return classroomService.getById(id);
    }
}
