package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.report.Report;
import hu.zsra.enaplo.model.user.*;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    public Long id;

    @Column(name = "name", length = 32, nullable = false)
    @Getter @Setter
    public String Name;
    @Column(name = "description", length = 500)
    @Getter @Setter
    public String Description;
    @Column(name = "started_at", nullable = false)
    @Getter @Setter
    public Date StartedAt;

    /* Relationships */

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    @Getter @Setter
    private Teacher Teacher;

    @OneToMany(mappedBy = "Course", cascade = CascadeType.ALL)
    @Getter @Setter
    private Set<Exam> Exams;

    @OneToMany(mappedBy = "Course", cascade = CascadeType.ALL)
    @Getter @Setter
    private Set<Report> Reports;

    public Course() {}

    public Course(String name, String description, Date startedAt, Teacher teacher) {
        Name = name;
        Description = description;
        StartedAt = startedAt;
        Teacher = teacher;
        Exams = new HashSet<>();
        Reports = new HashSet<>();
    }
}
