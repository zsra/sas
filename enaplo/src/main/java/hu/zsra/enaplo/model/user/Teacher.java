package hu.zsra.enaplo.model.user;

import hu.zsra.enaplo.model.Course;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Getter @Setter
    private User user;

    @OneToMany(mappedBy = "teacher")
    @Getter @Setter
    private Set<Course> courses;

    @OneToOne(mappedBy = "teacher")
    @Getter @Setter
    private HeadTeacher headTeacher;

    public Teacher() {
        this.courses = new HashSet<>();
        this.headTeacher = null;
    }

    public Teacher(User user) {
        this.user = user;
        this.user.setRole(Role.ROLE_TEACHER);
        this.courses = new HashSet<>();
        this.headTeacher = null;
    }
}
