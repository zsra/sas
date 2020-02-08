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

/**
 * Teacher model class to contains teacher data and build a relationship model.
 * The Teacher cannot creatable without user instance.
 */
@Entity
@Table(name = "teachers")
public class Teacher {

    /**
     * Id field [GENERATED AUTOMATICALLY].
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    /**
     * User object to teacher. This property connects the teacher to
     * the account.
     */
    @ManyToOne
    @JoinColumn(name="teacher_id")
    @Getter @Setter
    private User teacher;

    /**
     * Teacher e-mail.
     */
    @Column(name = "email", length = 64)
    @Getter
    @Setter
    private String email;

    /**
     * Teacher phone number.
     */
    @Column(name = "phone", nullable = false, length = 24)
    @Getter @Setter
    private String phone;

    /**
     * Empty constructor.
     */
    public Teacher() {}

    /**
     *  Constructor to make a new instance.
     *
     * @param teacher User object to teacher.
     * @param email Teacher e-mail.
     * @param phone Teacher phone number.
     */
    public Teacher(User teacher, String email, String phone) {
        this.teacher = teacher;
        this.email = email;
        this.phone = phone;
    }

    /**
     * Courses that the teacher teaching.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    @Getter @Setter
    private List<Course> courses = new ArrayList<>();
}
