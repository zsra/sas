package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;

    @PostMapping(value = "/courses/create")
    public Course create(Course course) {
        return courseService.create(course);
    }

    @PutMapping(value = "/courses/update/{id}")
    public Course update(@PathVariable Long id,
                         @Valid @RequestBody Course course) {
        return courseService.update(id, course);
    }

    @PutMapping(value = "/courses/setCourse/{student_id}")
    public String setCourse(@PathVariable Long student_id,
                            @RequestBody Long course_id) {
        courseService.setCourse(student_id, course_id);
        return course_id.toString();
    }

    @DeleteMapping(value = "/courses/{id}")
    public String delete(Long id) {
        courseService.delete(id);
        return id.toString();
    }
}
