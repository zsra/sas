package hu.zsra.enaplo.service;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Classroom;
import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.user.Role;
import hu.zsra.enaplo.model.user.Student;
import hu.zsra.enaplo.model.user.Teacher;
import hu.zsra.enaplo.repository.ClassroomRepository;
import hu.zsra.enaplo.repository.CourseRepository;
import hu.zsra.enaplo.repository.user.StudentRepository;
import hu.zsra.enaplo.repository.user.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    public Classroom create(Classroom classroom) {
        classroom.setHeadTeacher(setHeadTeacher(classroom.getHeadTeacher()));
        return classroomRepository.save(classroom);
    }

    public Set<Classroom> getAll() {
        return new HashSet<>(classroomRepository.findAll());
    }

    public Classroom getClassroomById(Long id) throws ResourceNotFoundException {
        return classroomRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classroom not found"));
    }

    public Set<Student> getStudentsFromClassroom(Long id) throws ResourceNotFoundException {
        Classroom classroom = getClassroomById(id);
        return classroom.getStudents();
    }

    public Classroom setCourse(Long id_classroom, Long id_course) throws ResourceNotFoundException {
        Classroom classroom = getClassroomById(id_classroom);

        Course course = courseRepository
                .findById(id_course)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found!"));

        for(Student student : classroom.getStudents()) {
            Student oldStudent = studentRepository
                    .findById(student.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
            oldStudent.getCourses().add(course);
            studentRepository.save(oldStudent);
        }

        return classroomRepository.save(classroom);
    }

    public Classroom update(Long id, Classroom classroom) throws ResourceNotFoundException {
        Classroom oldClassroom = getClassroomById(id);

        oldClassroom.getHeadTeacher().setRole(Role.ROLE_TEACHER);
        oldClassroom.setHeadTeacher(setHeadTeacher(classroom.getHeadTeacher()));
        oldClassroom.setEnd_year(classroom.getEnd_year());
        oldClassroom.setStart_year(classroom.getStart_year());
        oldClassroom.setLetter(classroom.getLetter());
        oldClassroom.setStudents(classroom.getStudents());
        oldClassroom.setYear(classroom.getYear());

        return classroomRepository.save(oldClassroom);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        classroomRepository.delete(getClassroomById(id));
    }

    private Teacher setHeadTeacher(Teacher teacher) {
        Teacher oldTeacher = teacherRepository.findByUsername(teacher.getUsername());
        teacher.setRole(Role.ROLE_HEADTEACHER);
        return oldTeacher;
    }
}
