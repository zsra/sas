package hu.zsra.enaplo.repository;

import hu.zsra.enaplo.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Long, Attendance> {
}
