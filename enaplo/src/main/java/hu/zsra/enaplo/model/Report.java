package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.group.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name="student_id")
    @Getter @Setter
    private Student student;

    @Column(name = "year", nullable = false)
    @Getter @Setter
    private int year;

    @Column(name = "semester", nullable = false)
    @Getter @Setter
    private int semester;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @Getter @Setter
    private Course course;

    @Column(name = "mark", nullable = false)
    @Getter @Setter
    private int mark;

    public Report() {
    }

    public Report(Student student, int year, int semester, Course course, int mark) {
        this.student = student;
        this.year = year;
        this.semester = semester;
        this.course = course;
        this.mark = mark;
    }
}
