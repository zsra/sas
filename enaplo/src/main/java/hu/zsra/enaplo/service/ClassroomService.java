package hu.zsra.enaplo.service;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Classroom;
import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.user.Student;
import hu.zsra.enaplo.repository.ClassroomRepository;
import hu.zsra.enaplo.repository.user.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private StudentRepository studentRepository;

    public Classroom create(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public List<Classroom> getAll() {
        return classroomRepository.findAll();
    }

    public Classroom setCourse(Long id, Course course) throws ResourceNotFoundException {
        Classroom classroom = classroomRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classroom not found"));

        for(Student student : classroom.getStudents()) {
            Student oldStudent = studentRepository
                    .findById(student.getId())
                    .orElse(null);
            assert oldStudent != null;
            oldStudent.getCourses().add(course);
            studentRepository.save(oldStudent);
        }

        return classroomRepository.save(classroom);
    }
}
