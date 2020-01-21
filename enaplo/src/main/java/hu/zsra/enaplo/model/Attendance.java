package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.group.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "attendances")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(name = "lecture", nullable = false)
    @Getter @Setter
    private int lecture;

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

    public Attendance(Student student, int lecture, LocalDate dateOfMiss) {
        this.student = student;
        this.lecture = lecture;
        this.dateOfMiss = dateOfMiss;
        this.isVerified = false;
    }


}
