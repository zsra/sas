package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.group.Student;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Message to student.
     */
    @Column(name = "text", nullable = false, length = 255)
    private String text;

    /**
     * remark created at this time.
     */
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
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
