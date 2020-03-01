package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.group.Student;

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
    private Long id;

    /**
     * School year when semester was.
     */
    @Column(name = "year", nullable = false)
    private int year;

    /**
     * The semester.
     */
    @Column(name = "semester", nullable = false)
    private int semester;

    /**
     * Course result in the semester.
     */
    @Column(name = "mark", nullable = false)
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
    private Student student;

    /**
     * Report which belongs to this course.
     */
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
