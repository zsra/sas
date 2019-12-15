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
    private String Title;
    @Column(name = "mark", nullable = false)
    @Getter @Setter
    private byte Mark;
    @Column(name = "weight", nullable = false)
    @Getter @Setter
    private double Weight;
    @Column(name = "written_at", nullable = false)
    @Getter @Setter
    private Date WrittenAt;
    @Column(name = "comment", length = 200)
    @Getter @Setter
    private String Comment;

    /* Relationships */

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @Getter @Setter
    private Student Student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @Getter @Setter
    private hu.zsra.enaplo.model.Course Course;

    public Exam() {}

    public Exam(String title, byte mark, double weight, Date writtenAt, String comment,
                Student student, Course course) {
        Title = title;
        Mark = mark;
        Weight = weight;
        WrittenAt = writtenAt;
        Comment = comment;
        Student = student;
        Course = course;
    }
}
