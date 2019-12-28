package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Lesson;
import hu.zsra.enaplo.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/timetables")
public class TimeTableController {

    @Autowired
    private TimeTableService timeTableService;

    @PostMapping("/create")
    public Lesson create(@RequestBody Lesson lesson) {
        return timeTableService.create(lesson);
    }

    @PutMapping("/update/{id}")
    public Lesson update(@PathVariable Long id,
                         @Valid @RequestBody Lesson lesson) throws ResourceNotFoundException {
        return timeTableService.update(id, lesson);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) throws ResourceNotFoundException {
        timeTableService.delete(id);
        return id.toString();
    }
}
