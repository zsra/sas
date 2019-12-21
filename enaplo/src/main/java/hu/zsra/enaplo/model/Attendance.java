package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.Student;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "attendances")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(name = "created_at", nullable = false)
    @Getter @Setter
    private Date startedAt;

    @Column(name = "ended_at", nullable = false)
    @Getter @Setter
    private Date endedAt;

    @Column(name = "is_proven", nullable = false)
    @Getter @Setter
    private boolean isProven;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @Getter @Setter
    private Student student;

    public Attendance() {
    }

    public Attendance(Date startedAt, Date endedAt, Student student) {
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.student = student;
    }
}
