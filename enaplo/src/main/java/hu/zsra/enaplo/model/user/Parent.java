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
    private User user;

    public Parent() { }

    public Parent(User user) {
        this.user = user;
        this.user.setRole(Role.ROLE_PARENT);
    }
}