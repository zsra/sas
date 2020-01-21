package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.response.CourseResponseDTO;
import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;

    @GetMapping(value = "/courses/all")
    public List<Course> findALl() {
        return this.courseService.findAll();
    }

    @GetMapping(value = "/courses/{id}")
    public Course FindById(@PathVariable Long id) {
        return this.courseService.findById(id);
    }

    @PostMapping(value = "/courses/create")
    public Course create(CourseResponseDTO courseResponseDTO) {
        return courseService.create(courseResponseDTO);
    }

    @PutMapping(value = "/courses/update/{id}")
    public Course update(@PathVariable Long id,
                         @RequestBody CourseResponseDTO courseResponseDTO) {
        return courseService.update(id, courseResponseDTO);
    }

    @DeleteMapping(value = "/courses/{id}")
    public String delete(Long id) {
        courseService.delete(id);
        return id.toString();
    }

    @PutMapping(value = "/courses/setCourse/{student_id}")
    public String setCourse(@PathVariable Long student_id,
                            @RequestBody Long course_id) {
        courseService.setCourse(student_id, course_id);
        return course_id.toString();
    }


}
