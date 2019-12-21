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
    public String name;
    @Column(name = "description", length = 500)
    @Getter @Setter
    public String description;
    @Column(name = "started_at", nullable = false)
    @Getter @Setter
    public Date startedAt;

    /* Relationships */

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    @Getter @Setter
    private Teacher teacher;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @Getter @Setter
    private Set<Exam> exams;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @Getter @Setter
    private Set<Report> reports;

    public Course() {}

    public Course(String name, String description, Date startedAt, Teacher teacher) {
        this.name = name;
        this.description = description;
        this.startedAt = startedAt;
        this.teacher = teacher;
        this.exams = new HashSet<>();
        this.reports = new HashSet<>();
    }
}
