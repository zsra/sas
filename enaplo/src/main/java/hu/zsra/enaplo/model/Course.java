package hu.zsra.enaplo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.zsra.enaplo.model.exam.Exam;
import hu.zsra.enaplo.model.user.Student;
import hu.zsra.enaplo.model.user.Teacher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
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

    @Column(name = "year", nullable = false)
    @Getter @Setter
    private int year;

    @Column(name = "description", length = 500)
    @Getter @Setter
    private String description;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    @Getter @Setter
    private Teacher teacher;

    @JsonIgnore
    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
    @Getter @Setter
    private Set<Student> students = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    @Getter @Setter
    private Set<Exam> exams = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    @Getter @Setter
    private Set<Lesson> lessons = new HashSet<>();

    public Course() {}

    public Course(String title, int year, String description, Teacher teacher) {
        this.title = title;
        this.year = year;
        this.description = description;
        this.teacher = teacher;
    }
}
