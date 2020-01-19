package hu.zsra.enaplo.service;

import hu.zsra.enaplo.model.Classroom;
import hu.zsra.enaplo.model.user.group.Student;

import java.util.List;

public interface ClassroomService {

    List<Classroom> getAll();
    Classroom create(Classroom classroom);
    Classroom update(Long id, Classroom classroom);
    void delete(Long id);
    Classroom getByHeadTeacher(Long id);
    List<Student> getStudentsFromClassroom(Long id);
    void setCourse(Long classroom_id, Long course_id);
    Classroom getById(Long id);
}
