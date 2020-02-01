package hu.zsra.enaplo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.model.user.group.Teacher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(name = "title", nullable = false, length = 24)
    @Getter @Setter
    private String title;

    @Column(name = "year", nullable = false)
    @Getter @Setter
    private int year;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    @Getter @Setter
    private Teacher teacher;

    public Course() {}

    public Course(String title, int year, Teacher teacher) {
        this.title = title;
        this.year = year;
        this.teacher = teacher;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
    @Getter @Setter
    private List<Student> students = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    @Getter @Setter
    private List<Exam> exams = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    @Getter @Setter
    private List<TimeTableEntity> lessons = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    @Getter @Setter
    private List<Report> reports = new ArrayList<>();

}
