package hu.zsra.enaplo.model.user;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_ADMIN,
    ROLE_TEACHER,
    ROLE_PARENT,
    ROLE_HEADTEACHER,
    ROLE_STUDENT;

    public String getAuthority() {
        return name();
    }
}
