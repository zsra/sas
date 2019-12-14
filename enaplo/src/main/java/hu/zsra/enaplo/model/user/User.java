package hu.zsra.enaplo.model.user;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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
    private String Username;

    @Column(name = "password", nullable = false)
    @Getter @Setter
    private String Password;

    /* Name info */

    @Column(name = "firstname", length = 24, nullable = false)
    @Getter @Setter
    private String FirstName;
    @Column(name = "middlename", length = 16, nullable = false)
    @Getter @Setter
    private String MiddleName;
    @Column(name = "lastname", length = 16, nullable = false)
    @Getter @Setter
    private String LastName;

    /* Date of Birth */

    @Column(name = "dob", nullable = false)
    @Getter @Setter
    private Date DateOfBirth;

    /* Contact Info */

    @Column(name = "email", length = 64)
    @Getter @Setter
    private String Email;
    @Column(name = "phone", length = 16)
    @Getter @Setter
    private String Phone;

    /* Role info */

    @ElementCollection(targetClass = Role.class)
    @JoinTable(name = "tbl_roles", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "roles", nullable = false)
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    Set<Role> Roles = new HashSet<>();

    /* Account status */

    @Column(name = "status", nullable = false)
    @Getter @Setter
    private Boolean Status;
    @Column(name = "last_login")
    @Getter @Setter
    private Date LastLogin;

    public User() {}

    public User(String username, String password, String firstName, String middleName,
                String lastName, Date dateOfBirth, String email, String phone, Set<Role> roles,
                Boolean status, Date lastLogin) {
        Username = username;
        Password = password;
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        DateOfBirth = dateOfBirth;
        Email = email;
        Phone = phone;
        Roles = roles;
        Status = status;
        LastLogin = lastLogin;
    }
}
