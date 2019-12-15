package hu.zsra.enaplo.repository;

import hu.zsra.enaplo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Long, Course> {
}
