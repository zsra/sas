package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.response.RemarkResponseDTO;
import hu.zsra.enaplo.model.Remark;
import hu.zsra.enaplo.service.impl.RemarkServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The {@link RemarkController} contains all rest api function that need to
 * manage the {@link hu.zsra.enaplo.model.Remark}.
 *
 * @see hu.zsra.enaplo.model.Remark
 * @see hu.zsra.enaplo.service.impl.RemarkServiceImpl
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class RemarkController {

    @Autowired
    private RemarkServiceImpl remarkService;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')" +
            "or @securityService.hasStudentAccess(principal.id, #student_id)")
    @ApiOperation(value = "${RemarkController.findAllByStudent}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Remarks don't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PostMapping(value = "/remarks/{student_id}")
    public List<Remark> findAllByStudent(@PathVariable Long student_id) {
        return remarkService.findAllByStudent(student_id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')" +
            "or @securityService.hasStudentAccess(principal.id, #student_id)")
    @ApiOperation(value = "${RemarkController.findById}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Remark doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping(value = "/remarks/{id}")
    public Remark findById(@PathVariable Long id) {
        return remarkService.findById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${RemarkController.create}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Remark cannot created"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PostMapping(value = "/remarks/create")
    public Remark create(@RequestBody RemarkResponseDTO remarkResponseDTO) {
        return remarkService.create(remarkResponseDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${RemarkController.update}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Remark doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PutMapping(value = "/remarks/update/{id}")
    public Remark update(@PathVariable Long id,
                       @RequestBody RemarkResponseDTO remarkResponseDTO) {
        return remarkService.update(id, remarkResponseDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${RemarkController.delete}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Remark doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @DeleteMapping(value = "/remarks/{id}")
    public String delete(@PathVariable Long id) {
        remarkService.delete(id);
        return id.toString();
    }
}
