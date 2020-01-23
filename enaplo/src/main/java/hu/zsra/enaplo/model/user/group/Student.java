package hu.zsra.enaplo.model.user.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.zsra.enaplo.model.*;
import hu.zsra.enaplo.model.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name="student_id")
    @Getter @Setter
    private User student;

    @Column(name = "dob", nullable = false)
    @Getter @Setter
    private LocalDate dateOfBirth;

    @Column(name = "start_year", nullable = false)
    @Getter @Setter
    private int start_year;

    @Column(name = "address", nullable = false)
    @Getter @Setter
    private String address;

    @Column(name = "educationId", nullable = false, length = 11)
    @Getter @Setter
    private String educationId;

    @Column(name = "healthCareId", length = 16)
    @Getter @Setter
    private String healthCareId;

    @Column(name = "parent1Name", length = 32)
    @Getter @Setter
    private String parent1Name;

    @Column(name = "parent2Name", length = 32)
    @Getter @Setter
    private String parent2Name;

    @Column(name = "parent1Phone", length = 24)
    @Getter @Setter
    private String parent1Phone;

    @Column(name = "parent2Phone", length = 24)
    @Getter @Setter
    private String parent2Phone;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    @Getter @Setter
    private List<Exam> exams  = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    @Getter @Setter
    private List<Attendance> attendances = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="classroom_id")
    @Getter @Setter
    private Classroom classroom;

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

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    @Getter @Setter
    private List<Report> reports = new ArrayList<>();

}
