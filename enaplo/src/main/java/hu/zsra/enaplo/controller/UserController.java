package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.response.UserResponseDTO;
import hu.zsra.enaplo.model.user.User;
import hu.zsra.enaplo.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/all")
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/user/{id}")
    public User getById(@PathVariable Long id) {
        return  userService.findById(id);
    }

    @PostMapping(value = "/user/reset-credentials/{username}")
    public ResponseEntity<Map> resetCredentials(@PathVariable  String username) {
        userService.resetCredentials(username);
        Map<String, String> result = new HashMap<>();
        result.put("result", "success");
        return ResponseEntity.accepted().body(result);
    }

    @GetMapping(value = "/user/username/{username}")
    public boolean isUsernameUnique(@PathVariable String username) {
        return userService.isUsernameUnique(username);
    }

    @PutMapping(value = "/user/update/{id}")
    public User update(@PathVariable Long id,
                       @RequestBody UserResponseDTO userResponseDTO) {
        return userService.update(id, userResponseDTO);
    }

    @PostMapping(value = "/user/create")
    public ResponseEntity<?> addUser(@RequestBody UserResponseDTO userResponseDTO,
                                     UriComponentsBuilder ucBuilder) {
        User user = userService.save(userResponseDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping("/user/whoami")
    public User user() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
