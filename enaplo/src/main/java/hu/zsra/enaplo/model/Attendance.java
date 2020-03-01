package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.group.Student;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Attendance model class to contains attendance data for student. Attendance created
 * by class form.
 */
@Entity
@Table(name = "attendances")
public class Attendance {

    /**
     * Id field [GENERATED AUTOMATICALLY].
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Lecture when student missed.
     */
    @Column(name = "lecture", nullable = false)
    private int lecture;

    /**
     * Date when student missed.
     */
    @Column(name = "dateOfMiss", nullable = false)
    private LocalDate dateOfMiss;

    /**
     * Attendance is verified or not.
     */
    @Column(name = "isVerified")
    private boolean isVerified;

    /**
     * Empty constructor.
     */
    public Attendance() {}

    /**
     * Constructor to make a new instance.
     *
     * @param student Student who missed the lecture.
     * @param lecture Lecture when student missed.
     * @param dateOfMiss Date when student missed.
     */
    public Attendance(Student student, int lecture, LocalDate dateOfMiss) {
        this.student = student;
        this.lecture = lecture;
        this.dateOfMiss = dateOfMiss;
        this.isVerified = false;
    }

    /**
     * Student who missed the lecture.
     */
    @ManyToOne
    @JoinColumn(name="student_id", nullable = false)
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLecture() {
        return lecture;
    }

    public void setLecture(int lecture) {
        this.lecture = lecture;
    }

    public LocalDate getDateOfMiss() {
        return dateOfMiss;
    }

    public void setDateOfMiss(LocalDate dateOfMiss) {
        this.dateOfMiss = dateOfMiss;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
