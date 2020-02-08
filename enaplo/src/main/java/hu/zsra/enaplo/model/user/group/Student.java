package hu.zsra.enaplo.model.user.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hu.zsra.enaplo.model.*;
import hu.zsra.enaplo.model.user.User;
import hu.zsra.enaplo.model.user.UserRoleName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Student model class to contains student data and build a relationship model.
 * The student cannot creatable without user instance.
 */
@Entity
@Table(name = "students")
public class Student {

    /**
     * Id field [GENERATED AUTOMATICALLY].
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    /**
     * User object to student. This property connects the student to 
     * the account.
     */
    @ManyToOne
    @JoinColumn(name="student_id")
    @Getter @Setter
    private User student;

    /**
     * Student Date of Birth.
     */
    @Column(name = "dob", nullable = false)
    @Getter @Setter
    private LocalDate dateOfBirth;

    /**
     * Gender.
     */
    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    @Getter @Setter
    private Gender gender;

    /**
     * Year when student started.
     */
    @Column(name = "start_year", nullable = false)
    @Getter @Setter
    private int start_year;

    /**
     * Student address.
     */
    @Column(name = "address", nullable = false)
    @Getter @Setter
    private String address;

    /**
     * Student education id.
     */
    @Column(name = "educationId", nullable = false, length = 11)
    @Getter @Setter
    private String educationId;

    /**
     * Student healthcare id.
     */
    @Column(name = "healthCareId", length = 16)
    @Getter @Setter
    private String healthCareId;

    /**
     * Student "first" parent name.
     */
    @Column(name = "parent1Name", length = 32)
    @Getter @Setter
    private String parent1Name;

    /**
     * Student "second" parent name.
     */
    @Column(name = "parent2Name", length = 32)
    @Getter @Setter
    private String parent2Name;

    /**
     * Student "first" parent phone number.
     */
    @Column(name = "parent1Phone", length = 24)
    @Getter @Setter
    private String parent1Phone;

    /**
     * Student "second" parent phone number.
     */
    @Column(name = "parent2Phone", length = 24)
    @Getter @Setter
    private String parent2Phone;

    /**
     * Empty constructor.
     */
    public Student() {

    }

    /**
     * Constructor to make a new instance.
     *
     * @param student User object to student.
     * @param dateOfBirth Student Date of Birth.
     * @param start_year Year when student started.
     * @param address Student address.
     * @param gender Gender.
     * @param educationId Student education id.
     * @param healthCareId Student healthcare id.
     * @param parent1Name Student "first" parent name.
     * @param parent2Name Student "second" parent name.
     * @param parent1Phone Student "first" parent phone number.
     * @param parent2Phone Student "second" parent phone number.
     * @param classroom Class where student learn.
     */
    public Student(User student, LocalDate dateOfBirth, int start_year, String address, Gender gender,
                   String educationId, String healthCareId, String parent1Name,
                   String parent2Name, String parent1Phone, String parent2Phone, Classroom classroom) {
        this.student = student;
        this.dateOfBirth = dateOfBirth;
        this.start_year = start_year;
        this.address = address;
        this.gender = gender;
        this.educationId = educationId;
        this.healthCareId = healthCareId;
        this.parent1Name = parent1Name;
        this.parent2Name = parent2Name;
        this.parent1Phone = parent1Phone;
        this.parent2Phone = parent2Phone;
        this.classroom = classroom;
    }

    /**
     * Student courses. (Only the current year courses.)
     */
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = { @JoinColumn(name = "studentId") },
            inverseJoinColumns = { @JoinColumn(name = "courseId"),
            }
    )
    @Getter @Setter
    private List<Course> courses = new ArrayList<>();


    /**
     * Student reports. (Only the current year reports.)
     */
    @JsonIgnore
    @OneToMany(mappedBy = "student")
    @Getter @Setter
    private List<Report> reports = new ArrayList<>();

    /**
     * Student exams. (Only the current year exams.)
     */
    @JsonIgnore
    @OneToMany(mappedBy = "student")
    @Getter @Setter
    private List<Exam> exams  = new ArrayList<>();

    /**
     * Student attendances. (Only the current year attendances.)
     */
    @JsonIgnore
    @OneToMany(mappedBy = "student")
    @Getter @Setter
    private List<Attendance> attendances = new ArrayList<>();

    /**
     * Class where student learn.
     */
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name="classroom_id")
    @Getter @Setter
    private Classroom classroom;
}
