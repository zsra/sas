package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.AttendanceDTO;
import hu.zsra.enaplo.model.Attendance;
import hu.zsra.enaplo.service.impl.AttendanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AttendanceController {

    @Autowired
    private AttendanceServiceImpl attendanceService;

    @GetMapping(value = "/attendances/{classroom_id}")
    public List<AttendanceDTO> getForm(@PathVariable Long classroom_id) {
        return attendanceService.getForm(classroom_id);
    }

    @PostMapping(value = "/attendances/create")
    public List<Attendance> create(@RequestBody List<AttendanceDTO> attendanceDTOS,
                                   @RequestBody int lesson,
                                   @RequestBody LocalDate dateOfMiss) {
        return attendanceService.create(attendanceDTOS, lesson, dateOfMiss);
    }

    @PutMapping(value = "/attendances/verify/{id}")
    public String verify(@PathVariable Long id) {
        attendanceService.verify(id);
        return id.toString();
    }

    @GetMapping(value = "/attendances/nonVerify/{student_id}")
    public List<Attendance> nonVerifyByStudent( @PathVariable Long student_id) {
        return attendanceService.nonVerifyByStudent(student_id);
    }

    @GetMapping(value = "/attendances/all/{student_id}")
    public List<Attendance> getAllByStudent(Long student_id) {
        return attendanceService.getAllByStudent(student_id);
    }

    @DeleteMapping(value = "/attendances/{id}")
    public String delete(Long id) {
        attendanceService.delete(id);
        return id.toString();
    }
}
