package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.SummaryDTO;
import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Attendance;
import hu.zsra.enaplo.model.Remark;
import hu.zsra.enaplo.model.Report;
import hu.zsra.enaplo.model.user.Student;
import hu.zsra.enaplo.service.AttendanceService;
import hu.zsra.enaplo.service.RecordService;
import hu.zsra.enaplo.service.RemarkService;
import hu.zsra.enaplo.service.ReportService;
import hu.zsra.enaplo.service.user.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private RecordService recordService;
    @Autowired
    private ReportService reportService;
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private RemarkService remarkService;

    @PostMapping("/signin")
    public String signIn(@RequestBody String username, @RequestBody String password) {
        return studentService.signIn(username, password);
    }

    @PostMapping("/create")
    public String create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @GetMapping("/{username}/summary")
    public Set<SummaryDTO> summary(@PathVariable String username) {
        return recordService.getSummary(username);
    }

    @GetMapping("/{username}/{year}/{semester}")
    public Set<Report> getReport(@PathVariable String username,
                                 @PathVariable int year, @PathVariable int semester) {
        return reportService.getReports(username, year, semester);
    }

    @GetMapping("/refresh")
    public String refresh(HttpServletRequest httpServletRequest) {
        return studentService.refresh(httpServletRequest.getRemoteUser());
    }

    @GetMapping("/{username}")
    public Student getStudentByUsername(@PathVariable String username) {
        return studentService.getStudentByUsername(username);
    }

    @GetMapping("/{username}/attendances")
    public Set<Attendance> getNonVerifiedAttendances(@PathVariable String username) throws ResourceNotFoundException {
        return attendanceService.getNonVerifiedAttendances(username);
    }

    @GetMapping("/{username}/remarks")
    public Set<Remark> getAllRemark(@PathVariable String username) {
        return remarkService.getByStudentUsername(username);
    }
}
