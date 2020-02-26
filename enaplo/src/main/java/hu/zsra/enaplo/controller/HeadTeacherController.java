package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.ClassroomCourseResultDTO;
import hu.zsra.enaplo.dto.FailedStudentDTO;
import hu.zsra.enaplo.service.impl.HeadTeacherServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The {@link HeadTeacherController} contains rest api function that need to
 * manage the HeadTeacher.
 *
 * @see hu.zsra.enaplo.service.impl.HeadTeacherServiceImpl
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class HeadTeacherController {

    @Autowired
    private HeadTeacherServiceImpl headTeacherService;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${HeadTeacherController.findFailedStudentsInClass}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "failed students don't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping(value = "/headteacher/find-failed/{classroom_id}")
    public List<FailedStudentDTO> findFailedStudentsInClass(@PathVariable Long classroom_id) {
        return headTeacherService.findFailedStudentsInClass(classroom_id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${HeadTeacherController.findFailedStudentsInClass}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "failed students don't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping(value = "/headteacher/show-result/{classroom_id}")
    public List<ClassroomCourseResultDTO> showResultByCourse(@PathVariable Long classroom_id) {
        return headTeacherService.showResultByCourse(classroom_id);
    }
}
