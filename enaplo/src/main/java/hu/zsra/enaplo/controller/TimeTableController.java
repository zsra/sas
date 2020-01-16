package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.model.TimeTableEntity;
import hu.zsra.enaplo.service.impl.TimeTableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class TimeTableController {

    @Autowired
    private TimeTableServiceImpl timeTableService;

    @GetMapping(value = "/timetables/create")
    public TimeTableEntity create(@RequestBody TimeTableEntity timeTableEntity) {
        return timeTableService.create(timeTableEntity);
    }

    @PutMapping(value = "/timetables/update/{id}")
    public TimeTableEntity update(@PathVariable Long id,
                                  @RequestBody TimeTableEntity timeTableEntity) {
        return timeTableService.update(id, timeTableEntity);
    }

    @DeleteMapping(value = "/timetables/{id}")
    public String delete(@PathVariable Long id) {
        timeTableService.delete(id);
        return id.toString();
    }

    @GetMapping(value = "/timetables/student/{id}")
    public TimeTableEntity[][] getTimeTableByStudent(@PathVariable Long id) {
        return timeTableService.getTimeTableByStudent(id);
    }

    @GetMapping(value = "/timetables/teacher/{id}")
    public TimeTableEntity[][] getTimeTableByTeacher(@PathVariable Long id) {
        return timeTableService.getTimeTableByTeacher(id);
    }
}
