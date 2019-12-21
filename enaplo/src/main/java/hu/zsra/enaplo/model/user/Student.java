package hu.zsra.enaplo.model.user;

import hu.zsra.enaplo.model.*;
import hu.zsra.enaplo.model.Exam;
import hu.zsra.enaplo.model.Remark;
import hu.zsra.enaplo.model.report.Report;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Getter @Setter
    private User user;

    @OneToMany(mappedBy = "student")
    @Getter @Setter
    private Set<Exam> exams;

    @ManyToMany
    @Getter @Setter
    private Set<Parent> parents;

    @OneToMany(mappedBy = "student")
    @Getter @Setter
    private Set<Attendance> attendances;

    @OneToMany(mappedBy = "student")
    @Getter @Setter
    private Set<Remark> remarks;

    @OneToMany(mappedBy = "student")
    @Getter @Setter
    private Set<Report> reports;

    public Student() {
        this.exams = new HashSet<>();
        this.parents = new HashSet<>();
        this.attendances = new HashSet<>();
        this.remarks = new HashSet<>();
        this.reports = new HashSet<>();
    }

    public Student(User user) {
        this.user = user;
        this.user.setRole(Role.ROLE_STUDENT);
        this.exams = new HashSet<>();
        this.parents = new HashSet<>();
        this.attendances = new HashSet<>();
        this.reports = new HashSet<>();
    }
}
