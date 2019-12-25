package hu.zsra.enaplo.model.user;

import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.Remark;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher extends User {

    @Column(name = "firstName", nullable = false, length = 24)
    @Getter
    @Setter
    private String firstName;

    @Column(name = "middleName", length = 24)
    @Getter @Setter
    private String middleName;

    @Column(name = "lastName", nullable = false, length = 24)
    @Getter @Setter
    private String lastName;

    @Column(name = "email", length = 64)
    @Getter @Setter
    private String email;

    @Column(name = "phone", nullable = false, length = 16)
    @Getter @Setter
    private String phone;

    @OneToMany(mappedBy = "teacher")
    @Getter @Setter
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "teacher")
    @Getter @Setter
    private Set<Remark> remarks = new HashSet<>();

    public Teacher() {}

    public Teacher(String username, String password, String firstName, String middleName,
                   String lastName, String email, String phone) {
        super(username, password, Role.ROLE_TEACHER);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
}
