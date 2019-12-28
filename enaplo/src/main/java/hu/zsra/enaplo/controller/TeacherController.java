package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.model.user.Teacher;
import hu.zsra.enaplo.service.ReportService;
import hu.zsra.enaplo.service.user.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Set;

@Service
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/create")
    public String create(@RequestBody Teacher teacher) {
        return teacherService.create(teacher);
    }

    @PostMapping("/signin")
    public String signIn(@RequestBody String username, @RequestBody String password) {
        return teacherService.signIn(username, password);
    }

    @GetMapping("/all")
    public Set<Teacher> getAll() {
        return teacherService.getAll();
    }

    @GetMapping("/{username}")
    public Teacher getTeacherByUsername(@PathVariable String username) {
        return teacherService.getTeacherByUsername(username);
    }

    @PutMapping("/update/{username}")
    public Teacher update(@PathVariable String username,
                                     @Valid @RequestBody Teacher teacher) {
        return teacherService.update(username, teacher);
    }

    @DeleteMapping("/{username}")
    public String delete(@PathVariable String username) {
        teacherService.delete(username);
        return username;
    }

    @GetMapping("/refresh")
    public String refresh(HttpServletRequest httpServletRequest) {
        return teacherService.refresh(httpServletRequest.getRemoteUser());
    }
}
