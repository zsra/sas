package hu.zsra.enaplo.repository.user;

import hu.zsra.enaplo.model.user.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

    Parent findByUsername(String username);
    boolean existsByUsername(String username);
    @Transactional
    void deleteByUsername(String username);
}
