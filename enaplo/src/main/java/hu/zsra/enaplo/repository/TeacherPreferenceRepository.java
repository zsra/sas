package hu.zsra.enaplo.repository;

import hu.zsra.enaplo.model.TeacherPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherPreferenceRepository extends JpaRepository<TeacherPreference, Long> {
}
