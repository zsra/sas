package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.AttendanceDTO;
import hu.zsra.enaplo.dto.response.AttendanceResponseDTO;
import hu.zsra.enaplo.model.Attendance;
import hu.zsra.enaplo.service.impl.AttendanceServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The {@link AttendanceController} contains all rest api function that need to
 * manage the {@link Attendance}.
 *
 * @see Attendance
 * @see AttendanceServiceImpl
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AttendanceController {

    @Autowired
    private AttendanceServiceImpl attendanceService;

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER') or" +
            "@securityService.hasStudentAccess(principal.id, #student_id)")
    @ApiOperation(value = "${AttendanceController.getAllByStudent}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Attendances don't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping(value = "/attendances/all/{student_id}")
    public List<Attendance> getAllByStudent(@PathVariable Long student_id) {
        return attendanceService.getAllByStudent(student_id);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${AttendanceController.create}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Attendances cannot created"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PostMapping(value = "/attendances/create")
    public List<Attendance> create(@RequestBody List<AttendanceResponseDTO> attendanceResponseDTOS) {
        return attendanceService.create(attendanceResponseDTOS);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${AttendanceController.delete}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Attendance doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @DeleteMapping(value = "/attendances/{id}")
    public String delete(@PathVariable Long id) {
        attendanceService.delete(id);
        return id.toString();
    }

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${AttendanceController.verify}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Attendance doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PutMapping(value = "/attendances/verify/{id}")
    public String verify(@PathVariable Long id) {
        attendanceService.verify(id);
        return id.toString();
    }

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${AttendanceController.getAllAttendancesByClassroom}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Classroom doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping(value = "/attendances/classroom/{classroom_id}")
    public List<Attendance> getAllAttendancesByClassroom(Long classroom_id) {
        return  attendanceService.getAllAttendancesByClassroom(classroom_id);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${AttendanceController.makeAttendanceFormToClassroom}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Classroom doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping(value = "/attendances/{classroom_id}")
        public List<AttendanceDTO> makeAttendanceFormToClassroom(@PathVariable Long classroom_id) {
        return attendanceService.makeAttendanceFormToClassroom(classroom_id);
    }
}
