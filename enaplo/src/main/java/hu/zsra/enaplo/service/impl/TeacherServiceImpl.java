package hu.zsra.enaplo.service.impl;

import hu.zsra.enaplo.dto.response.TeacherPreferenceResponseDTO;
import hu.zsra.enaplo.dto.response.TeacherResponseDTO;
import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.TeacherPreference;
import hu.zsra.enaplo.model.user.Authority;
import hu.zsra.enaplo.model.user.User;
import hu.zsra.enaplo.model.user.group.Teacher;
import hu.zsra.enaplo.repository.CourseRepository;
import hu.zsra.enaplo.repository.TeacherPreferenceRepository;
import hu.zsra.enaplo.repository.user.TeacherRepository;
import hu.zsra.enaplo.repository.user.UserRepository;
import hu.zsra.enaplo.service.TeacherService;
import hu.zsra.enaplo.service.auth.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class contains all related function implementations to the teacher.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TeacherPreferenceRepository teacherPreferenceRepository;
    @Autowired
    private AuthorityService authService;

    /**
     * Returns a List of Teachers.
     *
     * @return teachers from database.
     */
    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    /**
     * Returns a Teacher object by id, if teacher exist
     * or returns a null value.
     *
     * @param id Id of the teacher.
     * @return a teacher object by id.
     * @see Teacher
     */
    @Override
    public Teacher findById(Long id) {
        return teacherRepository
                .findById(id).orElse(null);
    }

    /**
     * Returns a Teacher object by username, if teacher exist
     * or returns a null value.
     *
     * @param user_id Id of the teacher user.
     * @return a teacher object by user id.
     * @see Teacher
     */
    @Override
    public Teacher findByUserId(Long user_id) {
        return teacherRepository
                .findAll()
                .stream()
                .filter(teacher -> teacher.getTeacher()
                        .getId().equals(user_id))
                .findAny()
                .orElse(null);
    }

    /**
     * Creates a new teacher and save into the database.
     *
     * @param teacherResponseDTO Submitted DTO from web application.
     * @return  a new Teacher object.
     * @see Teacher
     */
    @Override
    public Teacher create(TeacherResponseDTO teacherResponseDTO) {
        User user = userRepository.findByUsername(teacherResponseDTO.getUsername());
        Teacher teacher = new Teacher();
        teacher.setEmail(teacherResponseDTO.getEmail());
        teacher.setPhone(teacherResponseDTO.getPhone());
        List<Authority> authorities = authService.findByName("ROLE_TEACHER");
        user.setAuthorities(authorities);
        teacher.setTeacher(user);
        teacherRepository.save(teacher);
        teacherPreferenceRepository.save(new TeacherPreference(teacher, 1, 1, 1,1));
        return teacher;
    }

    /**
     * Updates a teacher from database by id.
     *
     * @param id Id of the teacher.
     * @param teacherResponseDTO Submitted DTO from web application.
     * @return an updated teacher.
     * @see Teacher
     */
    @Override
    public Teacher update(Long id, TeacherResponseDTO teacherResponseDTO) {
        Teacher teacher = teacherRepository.getOne(id);
        teacher.setEmail(teacherResponseDTO.getEmail());
        teacher.setPhone(teacherResponseDTO.getPhone());

        return teacherRepository.save(teacher);
    }

    /**
     * Deletes a teacher from database by id.
     *
     * @param id Id of the teacher.
     */
    @Override
    public void delete(Long id) {
        teacherRepository.delete(teacherRepository.getOne(id));
    }

    /**
     * Sets a course to teacher by ids.
     *
     * @param teacher_id Id of the Teacher.
     * @param course_id Id of the Course.
     */
    @Override
    public void setCourse(Long teacher_id, Long course_id) {
        Teacher teacher = teacherRepository.getOne(teacher_id);
        Course course = courseRepository.getOne(course_id);
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    /**
     * Set all weights for exam types.
     *
     * @param teacherPreferenceResponseDTO Submitted DTO from web application.
     */
    @Override
    public void setTeacherPreferences(TeacherPreferenceResponseDTO teacherPreferenceResponseDTO) {
        Teacher teacher = teacherRepository.getOne(teacherPreferenceResponseDTO.getTeacher_id());
        teacherPreferenceRepository.save(new TeacherPreference(
           teacher,
           teacherPreferenceResponseDTO.getTestWeight(),
           teacherPreferenceResponseDTO.getTopicTestWeight(),
           teacherPreferenceResponseDTO.getRepetitionWeight(),
           teacherPreferenceResponseDTO.getHomeworkWeight()
        ));
    }

    /**
     * Get all preferences by teacher id.
     *
     * @param teacher_id Id of the Teacher.
     * @return List of the TeacherPreferences.
     */
    @Override
    public TeacherPreference getAllTeacherPreferences(Long teacher_id) {
        return teacherPreferenceRepository.findAll()
                .stream()
                .filter(teacherPreference -> teacherPreference.getTeacher().getId().equals(teacher_id))
                .findAny()
                .orElse(null);
    }
}
