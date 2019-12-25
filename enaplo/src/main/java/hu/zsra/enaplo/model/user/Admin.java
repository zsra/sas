package hu.zsra.enaplo.model.user;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin extends User {

    public Admin() {}

    public Admin(String username, String password) {
        super(username, password, Role.ROLE_ADMIN);
    }
}
