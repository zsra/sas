package hu.zsra.enaplo.repository.user;

import hu.zsra.enaplo.model.user.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Long, Parent> {
}
