package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.dto.UserDTO;
import hu.zsra.enaplo.model.user.User;
import hu.zsra.enaplo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController  {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/signin")
    public String login(@RequestParam String username, @RequestParam String password) {
        return userService.signIn(username, password);
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody UserDTO userDTO) {
        return userService.signUp(modelMapper.map(userDTO, User.class));
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
}
