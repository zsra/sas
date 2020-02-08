package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.group.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Exam model class store exam info and result.
 */
@Entity
@Table(name = "exams")
public class Exam {

    /**
     * Id field [GENERATED AUTOMATICALLY].
     */
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Exam result.
     */
    @Column(name = "mark", nullable = false)
    @Getter @Setter
    private int mark;

    /**
     * Time when exam written.
     */
    @Column(name = "written_at", nullable = false)
    @Getter @Setter
    private LocalDate writtenAt;

    /**
     * Empty constructor.
     */
    public Exam() {}

    /**
     * Constructor to make a new instance.
     *
     * @param mark Exam result.
     * @param writtenAt Time when exam written.
     * @param course Course where student wrote the exam.
     * @param student Student who wrote the exam.
     */
    public Exam(int mark, LocalDate writtenAt, Course course, Student student) {
        this.mark = mark;
        this.writtenAt = writtenAt;
        this.course = course;
        this.student = student;
    }

    /**
     * Course where student wrote the exam.
     */
    @ManyToOne
    @JoinColumn(name="course_id")
    @Getter @Setter
    private Course course;

    /**
     * Student who wrote the exam.
     */
    @ManyToOne
    @JoinColumn(name="student_id")
    @Getter @Setter
    private Student student;
}
