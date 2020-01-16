package hu.zsra.enaplo.service.impl;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Classroom;
import hu.zsra.enaplo.model.user.Authority;
import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.repository.ClassroomRepository;
import hu.zsra.enaplo.repository.user.StudentRepository;
import hu.zsra.enaplo.repository.user.TeacherRepository;
import hu.zsra.enaplo.service.ClassroomService;
import hu.zsra.enaplo.service.auth.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    private AuthorityService authService;

    @Override
    public List<Classroom> getAll() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom create(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public Classroom update(Long id, Classroom classroom) throws ResourceNotFoundException {
        Classroom oldClassroom = getById(id);
        oldClassroom.setStart_year(classroom.getStart_year());
        oldClassroom.setEnd_year(classroom.getEnd_year());
        oldClassroom.setHeadTeacher(classroom.getHeadTeacher());
        oldClassroom.setLetter(classroom.getLetter());
        oldClassroom.setYear(classroom.getYear());

        List<Authority> authorities = authService.findByName("ROLE_HEADTEACHER");
        oldClassroom.getHeadTeacher().getTeacher().setAuthorities(authorities);

        return classroomRepository.save(oldClassroom);
    }

    @Override
    public void delete(Long id) {
        Classroom classroom = classroomRepository.getOne(id);
        List<Authority> authorities = authService.findByName("ROLE_TEACHER");
        classroom.getHeadTeacher().getTeacher().setAuthorities(authorities);
        classroomRepository.delete(classroomRepository.getOne(id));
    }

    @Override
    public Classroom getByHeadTeacher(Long id) {
        return classroomRepository
                .findAll()
                .stream().filter(classroom ->  classroom.getHeadTeacher().getId().equals(id))
                .findAny().orElse(new Classroom());
    }

    @Override
    public List<Student> getStudentsFromClassroom(Long id) {
        return studentRepository
                .findAll()
                .stream()
                .filter(student -> student.getClassroom().getId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public void setCourse(Long classroom_id, Long course_id) {
        List<Student> students = getStudentsFromClassroom(classroom_id);
        for(Student student : students) {
            classroomRepository.setCourseForClassroom(student.getId(), course_id);
        }
    }

    @Override
    public Classroom getById(Long id) throws ResourceNotFoundException {
        return classroomRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classroom not found!"));
    }
}
