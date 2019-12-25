package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year", nullable = false, length = 4)
    @Getter @Setter
    private int year;

    @Column(name = "semester", nullable = false, length = 1)
    @Getter @Setter
    private int semester;

    @Column(name = "mark", nullable = false, length = 1)
    @Getter @Setter
    private int mark;

    @ManyToOne
    @JoinColumn(name = "student_id" ,nullable = false)
    @Getter @Setter
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id" ,nullable = false)
    @Getter @Setter
    private Course course;

    @Column(name = "seen", nullable = false)
    @Getter @Setter
    private boolean seen;

    public Report() {}

    public Report(int year, int semester, int mark, Student student, Course course) {
        this.year = year;
        this.semester = semester;
        this.mark = mark;
        this.student = student;
        this.course = course;
        this.seen = false;
    }
}
