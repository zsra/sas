package hu.zsra.enaplo.model.user;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "parents")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Getter @Setter
    private User User;

    public Parent() { }

    public Parent(User user) {
        User = user;
        User.setRole(Role.ROLE_PARENT);
    }
}