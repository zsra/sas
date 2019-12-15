package hu.zsra.enaplo.repository.user;

import hu.zsra.enaplo.model.user.HeadTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadTeacherRepository extends JpaRepository<Long, HeadTeacher> {
}
