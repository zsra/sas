package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.response.TimeTableEntityResponseDTO;
import hu.zsra.enaplo.model.TimeTableEntity;
import hu.zsra.enaplo.service.impl.TimeTableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TimeTableController {

    @Autowired
    private TimeTableServiceImpl timeTableService;

    @GetMapping(value = "/timetables/student/{id}")
    public TimeTableEntity[][] getTimeTableByStudent(@PathVariable Long id) {
        return timeTableService.getTimeTableByStudent(id);
    }

    @GetMapping(value = "/timetables/teacher/{id}")
    public TimeTableEntity[][] getTimeTableByTeacher(@PathVariable Long id) {
        return timeTableService.getTimeTableByTeacher(id);
    }

    @GetMapping(value = "/timetables/course/{course_id}")
    public List<TimeTableEntity> getTimeTableEntitiesByCourse(@PathVariable Long course_id) {
        return timeTableService.getTimeTableEntitiesByCourse(course_id);
    }

    @GetMapping(value = "/timetables/{id}")
    public TimeTableEntity findById(@PathVariable Long id) {
        return timeTableService.findById(id);
    }

    @GetMapping(value = "/timetables/create")
    public TimeTableEntity create(@RequestBody TimeTableEntityResponseDTO timeTableEntityResponseDTO) {
        return timeTableService.create(timeTableEntityResponseDTO);
    }

    @PutMapping(value = "/timetables/update/{id}")
    public TimeTableEntity update(@PathVariable Long id,
                                  @RequestBody TimeTableEntityResponseDTO timeTableEntityResponseDTO) {
        return timeTableService.update(id, timeTableEntityResponseDTO);
    }

    @DeleteMapping(value = "/timetables/{id}")
    public String delete(@PathVariable Long id) {
        timeTableService.delete(id);
        return id.toString();
    }


}
