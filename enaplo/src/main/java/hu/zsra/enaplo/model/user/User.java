package hu.zsra.enaplo.model.user;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    /* Account info */

    @Column(name = "username", length = 24, nullable = false, unique = true)
    @Getter @Setter
    private String username;

    @Column(name = "password", nullable = false)
    @Getter @Setter
    private String password;

    /* Name info */

    @Column(name = "firstname", length = 24, nullable = false)
    @Getter @Setter
    private String firstName;
    @Column(name = "middlename", length = 16)
    @Getter @Setter
    private String middleName;
    @Column(name = "lastname", length = 16, nullable = false)
    @Getter @Setter
    private String lastName;

    /* Date of Birth */

    @Column(name = "dob", nullable = false)
    @Getter @Setter
    private Date dateOfBirth;

    /* Contact Info */

    @Column(name = "email", length = 64)
    @Getter @Setter
    private String email;
    @Column(name = "phone", length = 16)
    @Getter @Setter
    private String phone;

    /* Role info */
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private Role role;

    /* Account status */

    @Column(name = "status", nullable = false)
    @Getter @Setter
    private Boolean status;
    @Column(name = "last_login")
    @Getter @Setter
    private Date lastLogin;

    public User() {}

    public User(String username, String password, String firstName, String middleName,
                String lastName, Date dateOfBirth, String email, String phone, Role role,
                Boolean status, Date lastLogin) {
        this.username = username;
        this.password = password;

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;

        this.dateOfBirth = dateOfBirth;

        this.email = email;
        this.phone = phone;
        this.status = status;
        this.lastLogin = lastLogin;

        this.role = role;
    }
}
