package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.group.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Report model to store the semester result for each course.
 */
@Entity
@Table(name = "reports")
public class Report {

    /**
     * Id field [GENERATED AUTOMATICALLY].
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    /**
     * School year when semester was.
     */
    @Column(name = "year", nullable = false)
    @Getter @Setter
    private int year;

    /**
     * The semester.
     */
    @Column(name = "semester", nullable = false)
    @Getter @Setter
    private int semester;

    /**
     * Course result in the semester.
     */
    @Column(name = "mark", nullable = false)
    @Getter @Setter
    private int mark;

    /**
     * Empty constructor.
     */
    public Report() {
    }

    /**
     * Constructor to make a new instance.
     *
     * @param student Student who owe the result.
     * @param year School year when semester was.
     * @param semester The semester.
     * @param course The course.
     * @param mark Course result in the semester.
     */
    public Report(Student student, int year, int semester, Course course, int mark) {
        this.student = student;
        this.year = year;
        this.semester = semester;
        this.course = course;
        this.mark = mark;
    }

    /**
     * Student who owe the result.
     */
    @ManyToOne
    @JoinColumn(name="student_id")
    @Getter @Setter
    private Student student;

    /**
     * Report which belongs to this course.
     */
    @ManyToOne
    @JoinColumn(name = "course_id")
    @Getter @Setter
    private Course course;
}
