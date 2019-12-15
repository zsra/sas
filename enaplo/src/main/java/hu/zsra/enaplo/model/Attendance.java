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
    private Date StartedAt;

    @Column(name = "ended_at", nullable = false)
    @Getter @Setter
    private Date EndedAt;

    @Column(name = "is_proven", nullable = false)
    @Getter @Setter
    private boolean IsProven;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @Getter @Setter
    private Student Student;

}
