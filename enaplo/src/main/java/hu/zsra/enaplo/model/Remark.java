package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.Student;
import hu.zsra.enaplo.model.user.Teacher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "remarks")
public class Remark {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message", nullable = false, length = 200)
    @Getter @Setter
    private String message;

    @ManyToOne
    @Getter @Setter
    private Student student;

    @ManyToOne
    @Getter @Setter
    private Teacher teacher;

    @Column(name = "seen", nullable = false)
    @Getter @Setter
    private boolean seen;

    public Remark() {}

    public Remark(String message, Student student, Teacher teacher) {
        this.message = message;
        this.student = student;
        this.teacher = teacher;
    }
}
