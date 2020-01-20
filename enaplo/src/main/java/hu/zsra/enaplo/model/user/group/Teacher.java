package hu.zsra.enaplo.model.user.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    @Getter @Setter
    private User teacher;

    @Column(name = "email", length = 64)
    @Getter
    @Setter
    private String email;

    @Column(name = "phone", nullable = false, length = 24)
    @Getter @Setter
    private String phone;

    public Teacher() {}

    public Teacher(User teacher, String email, String phone) {
        this.teacher = teacher;
        this.email = email;
        this.phone = phone;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    @Getter @Setter
    private List<Course> courses = new ArrayList<>();
}
