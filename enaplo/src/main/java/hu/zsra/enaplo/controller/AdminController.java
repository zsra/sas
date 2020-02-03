package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.model.archive.Archive;
import hu.zsra.enaplo.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping(value = "/admin/newYear")
    public String newYear() {
        adminService.newYear();
        return "Done";
    }

    @GetMapping(value = "/admin/createArchive")
    public String createArchive() {
        return adminService.createArchive();
    }

    @GetMapping(value = "/admin/archives")
    public List<Archive> getArchive() {
        return adminService.getArchive();
    }

    @GetMapping(value = "/admin/finished/{classroom_id}")
    public String finished(@PathVariable Long classroom_id) {
        adminService.finished(classroom_id);
        return "Finished";
    }

    @GetMapping(value = "/admin/archive/{id}")
    public Archive getArchiveByArchiveId(@PathVariable Long id){
        return adminService.getArchiveById(id);
    }
}
