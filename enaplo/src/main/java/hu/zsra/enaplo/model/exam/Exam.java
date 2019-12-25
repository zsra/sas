package hu.zsra.enaplo.model.exam;

import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.user.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name="course_id")
    @Getter @Setter
    private Course course;

    @ManyToOne
    @JoinColumn(name="student_id")
    @Getter @Setter
    private Student student;

    public Exam() {}

    public Exam(ExamType examType, int mark, Course course, Student student) {
        this.examType = examType;
        this.mark = mark;
        this.course = course;
        this.student = student;
    }
}
