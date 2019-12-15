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
    private User User;

    @OneToMany(mappedBy = "Student")
    @Getter @Setter
    private Set<Exam> Exams;

    @ManyToMany
    @Getter @Setter
    private Set<Parent> Parents;

    @OneToMany(mappedBy = "Student")
    @Getter @Setter
    private Set<Attendance> Attendances;

    @OneToMany(mappedBy = "Student")
    @Getter @Setter
    private Set<Remark> Remarks;

    @OneToMany(mappedBy = "Student")
    @Getter @Setter
    private Set<Report> Reports;

    public Student() {
        Exams = new HashSet<>();
        Parents = new HashSet<>();
        Attendances = new HashSet<>();
        Remarks = new HashSet<>();
        Reports = new HashSet<>();
    }

    public Student(User user) {
        User = user;
        User.setRole(Role.ROLE_STUDENT);
        Exams = new HashSet<>();
        Parents = new HashSet<>();
        Attendances = new HashSet<>();
        Reports = new HashSet<>();
    }
}
