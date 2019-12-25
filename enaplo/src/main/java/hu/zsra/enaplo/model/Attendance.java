package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "attendances")
public class Attendance {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "letter", nullable = false)
    @Getter @Setter
    private int lesson;

    @Column(name = "dateOfMiss", nullable = false)
    @Getter @Setter
    private LocalDate dateOfMiss;

    @ManyToOne
    @JoinColumn(name="student_id", nullable = false)
    @Getter @Setter
    private Student student;

    @Column(name = "isVerified")
    @Getter @Setter
    private boolean isVerified;

    public Attendance() {}

    public Attendance(int lesson, LocalDate dateOfMiss, Student student) {
        this.lesson = lesson;
        this.dateOfMiss = dateOfMiss;
        this.student = student;
        this.isVerified = false;
    }
}
