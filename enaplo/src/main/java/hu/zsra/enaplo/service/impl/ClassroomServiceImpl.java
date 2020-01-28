package hu.zsra.enaplo.service.impl;

import hu.zsra.enaplo.dto.response.ClassroomResponseDTO;
import hu.zsra.enaplo.model.Classroom;
import hu.zsra.enaplo.model.user.Authority;
import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.model.user.group.Teacher;
import hu.zsra.enaplo.repository.ClassroomRepository;
import hu.zsra.enaplo.repository.user.StudentRepository;
import hu.zsra.enaplo.repository.user.TeacherRepository;
import hu.zsra.enaplo.service.ClassroomService;
import hu.zsra.enaplo.service.auth.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class contains all related function implementations to the classroom.
 */
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

    /**
     * Returns a List of Classroom.
     *
     * @return classrooms from database.
     */
    @Override
    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    /**
     * Returns a Classroom object by id, if classroom exist
     * or returns a null value.
     *
     * @param id Id of the classroom.
     * @return a classroom object by id.
     * @see Classroom
     */
    @Override
    public Classroom findById(Long id) {
        return classroomRepository.findById(id).orElse(null);
    }

    /**
     * Returns a Classroom object by Headteacher Id if classroom exist
     * or returns a null value.
     *
     * @param id Id of the headteacher
     * @return a classroom object by headteacher id.
     */
    @Override
    public Classroom findByHeadteacher(Long id) {
        return classroomRepository.findAll()
                .stream()
                .filter(classroom -> classroom.getHeadTeacher().getId().equals(id))
                .findAny()
                .orElse(null);
    }

    /**
     * Creates a new classroom and save into the database.
     *
     * @param classroomResponseDTO Submitted DTO from web application.
     * @return  a new Classroom object.
     * @see Classroom
     */
    @Override
    public Classroom create(ClassroomResponseDTO classroomResponseDTO) {
        /* Finds teacher by id. */
        Teacher teacher = teacherRepository.getOne(classroomResponseDTO.getHeadTeacher_id());
        Classroom classroom = new Classroom(
                classroomResponseDTO.getStart_year(),
                classroomResponseDTO.getEnd_year(),
                classroomResponseDTO.getYear(),
                classroomResponseDTO.getLetter(),
                teacher
        ); // Creates a new classroom.
        /* sets back a teacher role from ROLE_TEACHER to ROLE_HEADTEACHER. */
        classroomRepository.setHeadteacherFromTeacher(teacher.getId());
        return classroomRepository.save(classroom);
    }

    /**
     * Updates a classroom from database by id.
     *
     * @param id Id of the classroom.
     * @param classroomResponseDTO Submitted DTO from web application.
     * @return an updated classroom.
     * @see Classroom
     */
    @Override
    public Classroom update(Long id, ClassroomResponseDTO classroomResponseDTO) {
        /* Finds classroom by id. */
        Classroom classroom = classroomRepository.getOne(id);
        /* Finds teacher by id. */
        Teacher teacher = teacherRepository.getOne(classroomResponseDTO.getHeadTeacher_id());

        /* Updates the old classroom with a new data. */
        classroom.setStart_year(classroomResponseDTO.getStart_year());
        classroom.setEnd_year(classroomResponseDTO.getEnd_year());
        classroom.setHeadTeacher(teacher);
        classroom.setLetter(classroomResponseDTO.getLetter());
        classroom.setYear(classroomResponseDTO.getYear());

        /* sets  a teacher role from ROLE_HEADTEACHER to ROLE_TEACHER. */
        classroomRepository.setTeacherFromHeadteacher(classroom.getHeadTeacher().getTeacher().getId());
        /* sets  a teacher role from ROLE_TEACHER to ROLE_HEADTEACHER. */
        classroomRepository.setHeadteacherFromTeacher(teacher.getId());

        return classroomRepository.save(classroom);
    }

    /**
     * Deletes a classroom from database by id.
     *
     * @param id Id of the classroom.
     */
    @Override
    public void delete(Long id) {
        Classroom classroom = classroomRepository.getOne(id);
        List<Authority> authorities = authService.findByName("ROLE_TEACHER");
        classroom.getHeadTeacher().getTeacher().setAuthorities(authorities);
        classroomRepository.delete(classroomRepository.getOne(id));
    }

    /**
     * Returns a List of Students, who are in the class.
     *
     * @param id Id of the classroom.
     * @return List of students.
     */
    @Override
    public List<Student> getStudentsFromClassroom(Long id) {
        return studentRepository
                .findAll()
                .stream()
                .filter(student -> student.getClassroom().getId().equals(id))
                .collect(Collectors.toList());
    }

    /**
     * Sets a course to all student, who are in the class. This
     * method helps to update at a new year.
     *
     * @param classroom_id Id of the classroom.
     * @param course_id Id of the Course.
     */
    @Override
    public void setCourse(Long classroom_id, Long course_id) {
        List<Student> students = studentRepository
                .findAll()
                .stream()
                .filter(student -> student.getClassroom().getId().equals(classroom_id))
                .collect(Collectors.toList());
        for(Student student : students) {
            classroomRepository.setCourseForClassroom(student.getId(), course_id);
        }
    }


}
