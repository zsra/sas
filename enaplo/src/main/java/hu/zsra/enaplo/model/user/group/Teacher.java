package hu.zsra.enaplo.model.user.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private Long id;

    /**
     * User object to teacher. This property connects the teacher to
     * the account.
     */
    @ManyToOne
    @JoinColumn(name="teacher_id")
    private User teacher;

    /**
     * Teacher e-mail.
     */
    @Column(name = "email", length = 64)
    private String email;

    /**
     * Teacher phone number.
     */
    @Column(name = "phone", nullable = false, length = 24)
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
    private List<Course> courses = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
