package hu.zsra.enaplo.repository.user;

import hu.zsra.enaplo.model.user.group.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
