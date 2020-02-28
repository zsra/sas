package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.response.TeacherPreferenceResponseDTO;
import hu.zsra.enaplo.dto.response.TeacherResponseDTO;
import hu.zsra.enaplo.model.TeacherPreference;
import hu.zsra.enaplo.model.user.group.Teacher;
import hu.zsra.enaplo.service.impl.TeacherServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The {@link TeacherController} contains all rest api function that need to
 * manage the {@link Teacher} and teacher functions {@link TeacherServiceImpl}.
 *
 * @see Teacher
 * @see TeacherServiceImpl
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${TeacherController.findAll}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Teachers don't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping(value = "/teachers/all")
    public List<Teacher> findAll() {
        return teacherService.findAll();
    }

    @ApiOperation(value = "${TeacherController.findById}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Teacher doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping(value = "/teachers/{id}")
    public Teacher findById(@PathVariable Long id) {
        return teacherService.findById(id);
    }

    @ApiOperation(value = "${TeacherController.findById}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Teacher doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping(value = "/teachers/user/{user_id}")
    public Teacher findByUserId(@PathVariable Long user_id) {
        return teacherService.findByUserId(user_id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${TeacherController.create}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Teacher cannot created"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PostMapping(value = "/teachers/create")
    public Teacher create(@RequestBody TeacherResponseDTO teacherResponseDTO) {
        return teacherService.create(teacherResponseDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or @securityService.hasTeacherAccess(principal.id, #id)")
    @ApiOperation(value = "${TeacherController.update}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Teacher doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PutMapping(value = "/teachers/update/{id}")
    public Teacher update(@PathVariable Long id,
                          @RequestBody TeacherResponseDTO teacherResponseDTO) {
        return teacherService.update(id, teacherResponseDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${TeacherController.setCourse}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Teacher or Course doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PutMapping(value = "/teachers/setCourse/{teacher_id}")
    public String setCourse(@PathVariable Long teacher_id,
                            @RequestBody Long course_id) {
        teacherService.setCourse(teacher_id, course_id);
        return course_id.toString();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${TeacherController.delete}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Teacher doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @DeleteMapping(value = "/teachers/{id}")
    public String delete(@PathVariable Long id) {
        teacherService.delete(id);
        return id.toString();
    }

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${TeacherController.setTeacherPreferences}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Preferences cannot created"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PutMapping(value = "/teachers/preferences")
    public String setTeacherPreferences(@RequestBody TeacherPreferenceResponseDTO teacherPreferenceResponseDTO) {
        teacherService.setTeacherPreferences(teacherPreferenceResponseDTO);
        return teacherPreferenceResponseDTO.getTeacher_id().toString();
    }

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${TeacherController.getAllTeacherPreferences}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Preferences don't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping(value = "/teachers/preferences/{teacher_id}")
    public TeacherPreference getAllTeacherPreferences(@PathVariable Long teacher_id) {
        return teacherService.getAllTeacherPreferences(teacher_id);
    }
}
