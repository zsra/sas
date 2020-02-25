package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.response.MessageResponseDTO;
import hu.zsra.enaplo.model.Message;
import hu.zsra.enaplo.service.impl.MessageServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The {@link MessageController} contains all rest api function that need to
 * manage the {@link hu.zsra.enaplo.model.Message}.
 *
 * @see hu.zsra.enaplo.model.Message
 * @see hu.zsra.enaplo.service.impl.MessageServiceImpl
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MessageController {

    @Autowired
    private MessageServiceImpl messageService;

    @ApiOperation(value = "${MessageController.findAll}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Messages don't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping(value = "/messages/all")
    public List<Message> findAll() {
        return messageService.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TEACHER') or hasRole('ROLE_HEADTEACHER')" +
            "or @securityService.hasStudentAccess(principal.id, #student_id)")
    @ApiOperation(value = "${MessageController.findById}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Message doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @GetMapping(value = "/messages/{id}")
    public Message findById(@PathVariable Long id) {
        return messageService.findById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${MessageController.create}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Message cannot created"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PostMapping(value = "/messages/create")
    public Message create(@RequestBody MessageResponseDTO messageResponseDTO) {
        return messageService.create(messageResponseDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${MessageController.update}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Message doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @PutMapping(value = "/messages/update/{id}")
    public Message update(@PathVariable Long id,
                         @RequestBody MessageResponseDTO messageResponseDTO) {
        return messageService.update(id, messageResponseDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${MessageController.delete}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "Message doesn't found"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    @DeleteMapping(value = "/messages/{id}")
    public String delete(@PathVariable Long id) {
        messageService.delete(id);
        return id.toString();
    }
}
