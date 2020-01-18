package hu.zsra.enaplo.repository;

import hu.zsra.enaplo.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

    @Modifying
    @Query(value = "INSERT INTO student_course (student_id, course_id) values (:student_id, :course_id)", nativeQuery = true)
    @Transactional
    void setCourseForClassroom(@Param("student_id") Long student_id, @Param("course_id") Long course_id);

    @Modifying
    @Query(value = "UPDATE user_authority SET authority_id = 4 WHERE user_id = :teacher_id", nativeQuery = true)
    @Transactional
    void setHeadteacherFromTeacher(@Param("teacher_id") Long teacher_id);

    @Modifying
    @Query(value = "UPDATE user_authority SET authority_id = 3 WHERE user_id = :teacher_id", nativeQuery = true)
    @Transactional
    void setTeacherFromHeadteacher(@Param("teacher_id") Long teacher_id);
}
