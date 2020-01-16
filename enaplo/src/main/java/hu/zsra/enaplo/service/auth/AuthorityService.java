package hu.zsra.enaplo.service.auth;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.user.Authority;
import hu.zsra.enaplo.model.user.UserRoleName;

import java.util.List;

public interface AuthorityService {

    void save(UserRoleName userRoleName);
    List<Authority> findById(Long id) throws ResourceNotFoundException;
    List<Authority> findByName(String name);
}
