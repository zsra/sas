package hu.zsra.enaplo.service;

import hu.zsra.enaplo.dto.TeacherResponseDTO;
import hu.zsra.enaplo.model.user.group.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAll();
    Teacher findById(Long id);
    Teacher findByUserId(Long id);
    Teacher save(TeacherResponseDTO teacherResponseDTO);
    Teacher update(Long id, TeacherResponseDTO teacherResponseDTO);
    void setCourse(Long teacher_id, Long course_id);
    void delete(Long id);
}
