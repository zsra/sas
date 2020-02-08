package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.group.Student;
import lombok.Getter;
import lombok.Setter;

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
    @Getter @Setter
    private Long id;

    /**
     * Lecture when student missed.
     */
    @Column(name = "lecture", nullable = false)
    @Getter @Setter
    private int lecture;

    /**
     * Date when student missed.
     */
    @Column(name = "dateOfMiss", nullable = false)
    @Getter @Setter
    private LocalDate dateOfMiss;

    /**
     * Attendance is verified or not.
     */
    @Column(name = "isVerified")
    @Getter @Setter
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
    @Getter @Setter
    private Student student;
}
