package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.response.ClassroomResponseDTO;
import hu.zsra.enaplo.model.Classroom;
import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.service.impl.ClassroomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ClassroomController {

    @Autowired
    private ClassroomServiceImpl classroomService;

    @GetMapping(value = "/classrooms/all")
    public List<Classroom> findAll() {
        return classroomService.findAll();
    }

    @GetMapping(value = "/classrooms/{id}")
    public Classroom findById(@PathVariable Long id) {
        return classroomService.findById(id);
    }

    @PostMapping(value = "/classrooms/create")
    public Classroom create(@RequestBody ClassroomResponseDTO classroomResponseDTO) {
        return classroomService.create(classroomResponseDTO);
    }

    @PutMapping(value = "/classrooms/update/{id}")
    public Classroom update(@PathVariable Long id,
                            @RequestBody ClassroomResponseDTO classroomResponseDTO) {
        return classroomService.update(id, classroomResponseDTO);
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

    @DeleteMapping(value = "/classrooms/{id}")
    public String delete(Long id) {
        classroomService.delete(id);
        return id.toString();
    }
}
