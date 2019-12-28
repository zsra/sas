package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.model.user.Parent;
import hu.zsra.enaplo.service.user.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@RestController
@RequestMapping("/parents")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @PostMapping("/signin")
    public String signIn(@RequestBody String username, @RequestBody String password) {
        return parentService.signIn(username, password);
    }

    @PostMapping("/create")
    public Parent create(@RequestBody Parent parent) {
        return parentService.create(parent);
    }

    @PutMapping("/update/{username}")
    public Parent update(@PathVariable String username,
                         @Valid @RequestBody Parent parent) {
        return parentService.update(username, parent);
    }

    @DeleteMapping("/{username}")
    public String delete(@PathVariable String username) {
        parentService.delete(username);
        return username;
    }

    @GetMapping("/refresh")
    public String refresh(HttpServletRequest httpServletRequest) {
        return parentService.refresh(httpServletRequest.getRemoteUser());
    }
}
