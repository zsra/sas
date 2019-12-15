package hu.zsra.enaplo.repository;

import hu.zsra.enaplo.model.Remark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemarkRepository extends JpaRepository<Long, Remark> {
}
