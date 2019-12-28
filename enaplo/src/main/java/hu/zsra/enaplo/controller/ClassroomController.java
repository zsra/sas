package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Classroom;
import hu.zsra.enaplo.model.user.Student;
import hu.zsra.enaplo.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @PostMapping("/create")
    public Classroom create(@RequestBody Classroom classroom) {
        return classroomService.create(classroom);
    }

    @GetMapping("/{id}")
    public Classroom getClassroomById(@PathVariable Long id) throws ResourceNotFoundException {
        return classroomService.getClassroomById(id);
    }

    @GetMapping("/all")
    public Set<Classroom> getAll() {
        return classroomService.getAll();
    }

    @GetMapping("{id}/students")
    public  Set<Student> getStudentsFromClassroom(@PathVariable Long id) throws ResourceNotFoundException {
        return  classroomService.getStudentsFromClassroom(id);
    }

    @PutMapping("/courses/{id_classroom}/{id_course}")
    public Classroom setCourseForStudents(@PathVariable(name = "id_classroom") Long id_classroom,
                                          @PathVariable(name = "id_course") Long id_course)
            throws ResourceNotFoundException {
        return classroomService.setCourse(id_classroom, id_course);
    }

    @PutMapping("/update/{id}")
    public Classroom update(@PathVariable Long id,
                            @Valid @RequestBody Classroom classroom) throws ResourceNotFoundException {
        return classroomService.update(id, classroom);
    }
}
