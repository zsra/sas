package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.ReportDTO;
import hu.zsra.enaplo.dto.response.ReportResponseDTO;
import hu.zsra.enaplo.model.Report;
import hu.zsra.enaplo.service.impl.ReportServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The {@link ReportController} contains all rest api function that need to
 * manage the {@link Report}.
 *
 * @see Report
 * @see ReportServiceImpl
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {

    @Autowired
    private ReportServiceImpl reportService;

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')" +
            "or @securityService.hasStudentAccess(principal.id, #student_id)")
    @ApiOperation(value = "${ReportController.getSemesterResultByStudent}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Semester doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PostMapping(value = "/reports/{student_id}/{year}")
    public List<Report> getSemesterResultByStudent(@PathVariable Long student_id,
                                                   @PathVariable int year, @RequestBody int semester) {
        return reportService.getSemesterResultByStudent(student_id, year, semester);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${ReportController.findById}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Report doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping(value = "/reports/{id}")
    public Report findById(@PathVariable Long id) {
        return reportService.findById(id);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${ReportController.create}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Report cannot created"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PostMapping(value = "/reports/create")
    public Report create(@RequestBody ReportResponseDTO reportResponseDTO) {
        return reportService.create(reportResponseDTO);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${ReportController.update}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Report doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PutMapping(value = "/reports/update/{id}")
    public Report update(@PathVariable Long id,
                         @RequestBody ReportResponseDTO reportResponseDTO) {
        return reportService.update(id, reportResponseDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${ReportController.delete}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Report doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @DeleteMapping(value = "/reports/{id}")
    public String delete(@PathVariable Long id) {
        reportService.delete(id);
        return id.toString();
    }

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${ReportController.makeReportFormToClassroom}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Report form cannot created"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping(value = "/reports/form/{classroom_id}")
    public List<ReportDTO> makeReportFormToClassroom(@PathVariable Long classroom_id){
        return reportService.makeReportFormToClassroom(classroom_id);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${ReportController.createReportsToClassroom}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Reports cannot created"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PostMapping(value = "/reports/form/create")
    public List<Report> createReportsToClassroom(@RequestBody List<ReportResponseDTO> reportResponseDTOS) {
        return reportService.createReportsToClassroom(reportResponseDTOS);
    }
}
