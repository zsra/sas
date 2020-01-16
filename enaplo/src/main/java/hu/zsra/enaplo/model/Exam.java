package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.group.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mark", nullable = false)
    @Getter @Setter
    private int mark;

    @Column(name = "written_at", nullable = false)
    @Getter @Setter
    private LocalDate writtenAt;

    @ManyToOne
    @JoinColumn(name="course_id")
    @Getter @Setter
    private Course course;

    @ManyToOne
    @JoinColumn(name="student_id")
    @Getter @Setter
    private Student student;

    public Exam() {}

    public Exam(int mark, LocalDate writtenAt, Course course, Student student) {
        this.mark = mark;
        this.writtenAt = writtenAt;
        this.course = course;
        this.student = student;
    }
}
