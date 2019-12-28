package hu.zsra.enaplo.model.exam;

import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.user.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "exam")
public class Exam {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "examType", nullable = false, length = 12)
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private ExamType examType;

    @Column(name = "mark", nullable = false, length = 1)
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

    public Exam(ExamType examType, LocalDate writtenAt, int mark, Course course, Student student) {
        this.examType = examType;
        this.writtenAt = writtenAt;
        this.mark = mark;
        this.course = course;
        this.student = student;
    }
}
