package hu.zsra.enaplo.repository;

import hu.zsra.enaplo.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTableRepository extends JpaRepository<Lesson, Long> {
}
