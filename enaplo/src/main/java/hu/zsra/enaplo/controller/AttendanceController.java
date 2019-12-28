package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Attendance;
import hu.zsra.enaplo.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/{username}/attendances/all")
    public Set<Attendance> getAttendances(@PathVariable String username) throws ResourceNotFoundException {
        return attendanceService.getAttendances(username);
    }

    @PostMapping("/create")
    public Attendance create(@RequestBody Attendance attendance) {
        return attendanceService.create(attendance);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) throws ResourceNotFoundException {
        attendanceService.delete(id);
        return id.toString();
    }

    @PutMapping("/{id}/verify")
    public String verify(@PathVariable Long id) throws ResourceNotFoundException {
        attendanceService.verify(id);
        return id.toString();
    }
}
