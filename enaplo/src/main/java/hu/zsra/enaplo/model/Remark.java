package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.Student;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "remark")
public class Remark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(name = "message", length = 500, nullable = false)
    @Getter @Setter
    private String Message;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @Getter @Setter
    private Student Student;

    public Remark() {}

    public Remark(String message, Student student) {
        Message = message;
        Student = student;
    }
}
