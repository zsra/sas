package hu.zsra.enaplo.repository;

import hu.zsra.enaplo.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Long, Classroom> {
}
