package hu.zsra.enaplo.repository.user;

import hu.zsra.enaplo.model.user.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findByUsername(String username);
    boolean existsByUsername(String username);
    @Transactional
    void deleteByUsername(String username);
}
