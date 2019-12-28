package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.model.user.Admin;
import hu.zsra.enaplo.service.user.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/signin")
    public String signIn(@RequestBody String username, @RequestBody String password) {
        return adminService.signIn(username, password);
    }

    @PostMapping("/create")
    public String create(@RequestBody Admin admin) {
        return adminService.create(admin);
    }

    @GetMapping("/{username}")
    public Admin getAdminById(@PathVariable  String username) {
        return adminService.getAdminByUsername(username);
    }

    @GetMapping("/refresh")
    public String refresh(HttpServletRequest httpServletRequest) {
        return adminService.refresh(httpServletRequest.getRemoteUser());
    }
}
