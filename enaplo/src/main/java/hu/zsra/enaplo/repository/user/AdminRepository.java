package hu.zsra.enaplo.repository.user;

import hu.zsra.enaplo.model.user.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByUsername(String username);
    boolean existsByUsername(String username);
    @Transactional
    void deleteByUsername(String username);
}
