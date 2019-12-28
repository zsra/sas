package hu.zsra.enaplo.controller;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Remark;
import hu.zsra.enaplo.service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/remarks")
public class RemarkController {

    @Autowired
    private RemarkService remarkService;

    @PostMapping("/create")
    public Remark create(@RequestBody Remark remark) {
        return remarkService.create(remark);
    }

    @GetMapping("/{id}")
    public Remark getById(@PathVariable Long id) throws ResourceNotFoundException {
        return remarkService.getById(id);
    }

    @PutMapping("/{id}")
    public Remark update(@PathVariable Long id,
                         @Valid @RequestBody Remark remark) throws ResourceNotFoundException {
        return remarkService.update(id, remark);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) throws ResourceNotFoundException {
        remarkService.delete(id);
        return id.toString();
    }
}
