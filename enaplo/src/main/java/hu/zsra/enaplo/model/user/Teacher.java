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
    private User User;

    @OneToMany(mappedBy = "Teacher")
    @Getter @Setter
    private Set<Course> Courses;

    @OneToOne(mappedBy = "Teacher")
    @Getter @Setter
    private HeadTeacher HeadTeacher;

    public Teacher() {
        Courses = new HashSet<>();
        HeadTeacher = null;
    }

    public Teacher(User user) {
        User = user;
        User.setRole(Role.ROLE_TEACHER);
        Courses = new HashSet<>();
        HeadTeacher = null;
    }
}
