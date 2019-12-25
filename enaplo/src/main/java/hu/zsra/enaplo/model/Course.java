package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.exam.Exam;
import hu.zsra.enaplo.model.user.Student;
import hu.zsra.enaplo.model.user.Teacher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 24)
    @Getter @Setter
    private String title;

    @Column(name = "description", length = 500)
    @Getter @Setter
    private String description;

    @ManyToOne
    @JoinColumn(name="teacher_id", nullable = false)
    @Getter @Setter
    private Teacher teacher;

    @ManyToMany(mappedBy = "courses")
    @Getter @Setter
    private Set<Student> students = new HashSet<>();

    @OneToMany(mappedBy = "course")
    @Getter @Setter
    private Set<Exam> exams = new HashSet<>();

    @OneToMany(mappedBy = "course")
    @Getter @Setter
    private Set<Report> reports = new HashSet<>();

    public Course() {}

    public Course(String title, String description, Teacher teacher) {
        this.title = title;
        this.description = description;
        this.teacher = teacher;
    }
}
