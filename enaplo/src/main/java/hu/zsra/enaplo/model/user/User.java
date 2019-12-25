package hu.zsra.enaplo.model.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
public class User {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 16, nullable = false)
    @Getter @Setter
    private String username;

    @Column(name = "password", nullable = false)
    @Getter @Setter
    private String password;

    @Column(name = "role", length = 16, nullable = false)
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private Role role;

    public User() {
    }

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
