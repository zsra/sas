package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    public Course create(@RequestBody Course course) {
        return courseService.create(course);
    }

    @GetMapping("/all")
    public Set<Course> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Long id) throws ResourceNotFoundException {
        return courseService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Course update(@PathVariable Long id,
                         @Valid @RequestBody Course course) throws ResourceNotFoundException {
        return courseService.update(id, course);
    }

    @PutMapping("/{id}/{username}")
    public String setCourseToStudent(@PathVariable(name = "id") Long id,
                                     @PathVariable(name = "username") String username) throws ResourceNotFoundException {
        courseService.setCourseToStudent(id, username);
        return username;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable  Long id) throws ResourceNotFoundException {
        courseService.delete(id);
        return id.toString();
    }
}
