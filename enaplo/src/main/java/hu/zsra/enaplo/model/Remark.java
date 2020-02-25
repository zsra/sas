package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.group.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Remark model class store remarks for student.
 */
@Entity
@Table(name = "remarks")
public class Remark {

    /**
     * Id field [GENERATED AUTOMATICALLY].
     */
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Message to student.
     */
    @Getter
    @Setter
    @Column(name = "text", nullable = false, length = 255)
    private String text;

    /**
     * remark created at this time.
     */
    @Getter
    @Setter
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    /**
     * Empty constructor.
     */
    public Remark() {}

    /**
     * Constructor to make a new instance.
     *
     * @param text Message to student.
     * @param student Student who get the remark.
     */
    public Remark(String text, Student student) {
        this.text = text;
        this.student = student;
    }

    /**
     * Student who get the remark.
     */
    @ManyToOne
    @JoinColumn(name="student_id")
    @Getter @Setter
    private Student student;
}
