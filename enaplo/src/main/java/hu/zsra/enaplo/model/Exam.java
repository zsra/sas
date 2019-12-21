package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.Student;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Column(name = "title", length = 16,nullable = false)
    @Getter @Setter
    private String title;
    @Column(name = "mark", nullable = false)
    @Getter @Setter
    private byte mark;
    @Column(name = "weight", nullable = false)
    @Getter @Setter
    private double weight;
    @Column(name = "written_at", nullable = false)
    @Getter @Setter
    private Date writtenAt;
    @Column(name = "comment", length = 200)
    @Getter @Setter
    private String comment;

    /* Relationships */

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @Getter @Setter
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @Getter @Setter
    private hu.zsra.enaplo.model.Course course;

    public Exam() {}

    public Exam(String title, byte mark, double weight, Date writtenAt, String comment,
                Student student, Course course) {
        this.title = title;
        this.mark = mark;
        this.weight = weight;
        this.writtenAt = writtenAt;
        this.comment = comment;
        this.student = student;
        this.course = course;
    }
}
