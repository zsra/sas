package hu.zsra.enaplo.service;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Remark;
import hu.zsra.enaplo.repository.RemarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RemarkService {

    @Autowired
    private RemarkRepository remarkRepository;

    public Remark create(Remark remark) {
        return remarkRepository.save(remark);
    }

    public Remark getById(Long id) throws ResourceNotFoundException {
        return remarkRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Remark not found"));
    }

    public Set<Remark> getByStudentUsername(String username) {
        return remarkRepository
                .findAll()
                .stream()
                .filter(remark -> remark.getStudent().getUsername().equals(username))
                .collect(Collectors.toSet());
    }

    public Remark update(Long id, Remark remark) throws ResourceNotFoundException {
        Remark oldRemark = getById(id);

        oldRemark.setMessage(remark.getMessage());
        oldRemark.setStudent(remark.getStudent());
        oldRemark.setTeacher(remark.getTeacher());

        return remarkRepository.save(oldRemark);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        Remark remark = getById(id);
        remarkRepository.delete(remark);
    }
}
