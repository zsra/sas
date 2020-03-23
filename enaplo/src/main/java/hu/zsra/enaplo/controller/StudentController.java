package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.response.StudentResponseDTO;
import hu.zsra.enaplo.dto.SummaryDTO;
import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.service.impl.StudentServiceImp;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * The {@link StudentController} contains all rest api function that need to
 * manage the {@link Student} and student functions {@link StudentServiceImp}.
 *
 * @see Student
 * @see StudentServiceImp
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    @Autowired
    private StudentServiceImp studentService;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${StudentController.findAll}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Students don't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping(value = "/students/all")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TEACHER', 'ROLE_HEADTEACHER') or " +
            "@securityService.hasStudentAccess(principal.id, #id)")
    @ApiOperation(value = "${StudentController.findById}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Student doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping(value = "/students/{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TEACHER', 'ROLE_HEADTEACHER') or " +
            "principal.id == #user_id")
    @ApiOperation(value = "${StudentController.findByUserId}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Student doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping(value = "/students/user/{user_id}")
    public Student findByUserId(@PathVariable Long user_id) {
        return studentService.findByUserId(user_id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${StudentController.create}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Student doesn't created"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PostMapping(value = "/students/create")
    public ResponseEntity<?> create(@RequestBody StudentResponseDTO studentResponseDTO,
                                  UriComponentsBuilder ucBuilder) {
        Student student = studentService.create(studentResponseDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(student.getId()).toUri());
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or @securityService.hasStudentAccess(principal.id, #id)")
    @ApiOperation(value = "${StudentController.update}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Student doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PutMapping(value = "/students/update/{id}")
    public Student update(@PathVariable Long id,
                          @RequestBody StudentResponseDTO studentResponseDTO) {
        return studentService.update(id, studentResponseDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${StudentController.delete}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Student doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @DeleteMapping(value = "/students/{id}")
    public String delete(@PathVariable Long id) {
        studentService.delete(id);
        return id.toString();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or  hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER') or @securityService.hasStudentAccess(principal.id, #id)")
    @ApiOperation(value = "${StudentController.summary}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "The student summary doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping("/students/summary/{id}")
    public List<SummaryDTO> summary(@PathVariable Long id) {
        return studentService.getSummary(id);
    }
}
