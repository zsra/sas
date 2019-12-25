package hu.zsra.enaplo.model.user;

import hu.zsra.enaplo.model.*;
import hu.zsra.enaplo.model.exam.Exam;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends User {

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

    @Column(name = "dob", nullable = false)
    @Getter @Setter
    private LocalDate dateOfBirth;

    @Column(name = "address", nullable = false)
    @Getter @Setter
    private String address;

    @Column(name = "educationId", nullable = false, length = 11)
    @Getter @Setter
    private String educationId;

    @Column(name = "healthCareId", length = 16)
    @Getter @Setter
    private String healthCareId;

    @ManyToOne
    @JoinColumn(name="classroom_id")
    @Getter @Setter
    private Classroom classroom;

    @ManyToMany
    @JoinTable(
            name = "student_parent",
            joinColumns = { @JoinColumn(name = "studentId") },
            inverseJoinColumns = { @JoinColumn(name = "parentId") }
    )
    @Getter @Setter
    private Set<Parent> parents = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = { @JoinColumn(name = "studentId") },
            inverseJoinColumns = { @JoinColumn(name = "courseId"),
            }
    )
    @Getter @Setter
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "student")
    @Getter @Setter
    private Set<Exam> exams = new HashSet<>();

    @OneToMany(mappedBy = "student")
    @Getter @Setter
    private Set<Report> reports = new HashSet<>();

    @OneToMany(mappedBy = "student")
    @Getter @Setter
    private Set<Attendance> attendances = new HashSet<>();

    @OneToMany(mappedBy = "student")
    @Getter @Setter
    private Set<Remark> remarks= new HashSet<>();

    public Student() {}

    public Student(String username, String password, String firstName, String middleName, String lastName,
                   LocalDate dateOfBirth, String address, String educationId, String healthCareId, Classroom classroom) {
        super(username, password, Role.ROLE_STUDENT);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.educationId = educationId;
        this.healthCareId = healthCareId;
        this.classroom = classroom;
    }

    public Student(String username, String password, String firstName, String middleName, String lastName,
                   LocalDate dateOfBirth, String address, String educationId, String healthCareId, Classroom classroom, Set<Parent> parents) {
        super(username, password, Role.ROLE_STUDENT);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.educationId = educationId;
        this.healthCareId = healthCareId;
        this.classroom = classroom;
        this.parents = parents;
    }
}
