package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.ExamDTO;
import hu.zsra.enaplo.dto.response.ExamResponseDTO;
import hu.zsra.enaplo.model.Exam;
import hu.zsra.enaplo.service.impl.ExamServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * The {@link ExamController} contains all rest api function that need to
 * manage the {@link Exam}.
 *
 * @see Exam
 * @see ExamServiceImpl
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExamController {

    @Autowired
    private ExamServiceImpl examService;

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${ExamController.findAllByStudent}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Exams don't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PostMapping(value = "/exams/student/{student_id}")
    public List<Exam> findAllByStudent(@PathVariable Long student_id,
                                       @RequestBody Long course_id) {
        return examService.findAllByStudent(student_id, course_id);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${ExamController.findById}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Exam doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping(value = "/exams/{id}")
    public Exam findById(@PathVariable Long id) {
        return examService.findById(id);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${ExamController.create}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Exam cannot created"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PostMapping(value = "/exams/create")
    public Exam create(@RequestBody ExamResponseDTO examResponseDTO) {
        return examService.create(examResponseDTO);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${ExamController.update}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Exam doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PutMapping(value = "/exams/update/{id}")
        public Exam update(@PathVariable Long id,
                       @RequestBody ExamResponseDTO examResponseDTO) {
        return examService.update(id, examResponseDTO);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${ExamController.delete}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Exam doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @DeleteMapping(value = "/exams/{id}")
    public String delete(@PathVariable Long id) {
        examService.delete(id);
        return id.toString();
    }

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${ExamController.makeExamsFormToClassroom}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Classroom doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PostMapping(value = "/exams/form/{classroom_id}")
    public List<ExamDTO> makeExamsFormToClassroom(@PathVariable Long classroom_id,
                                                  @RequestBody String written_at) {
        return examService.makeExamsFormToClassroom(classroom_id,LocalDate.parse(written_at));
    }

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')")
    @ApiOperation(value = "${ExamController.createExamsFromForm}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Exams cannot created"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PostMapping(value = "/exams/form/create")
    public List<Exam> createExamsFromForm(@RequestBody List<ExamResponseDTO> examResponseDTOS) {
        return examService.createExamsFromForm(examResponseDTOS);
    }
}
