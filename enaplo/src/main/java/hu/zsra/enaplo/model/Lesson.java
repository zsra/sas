package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "timeTables")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;


    @Column(name = "day", nullable = false)
    @Getter @Setter
    private int day;

    @Column(name = "lesson", nullable = false)
    @Getter @Setter
    private int lessonNumber;

    @ManyToOne
    @Getter @Setter
    private Course course;

    @Column(name = "classroomNumber", nullable = false, length = 15)
    @Getter @Setter
    private String classroomNumber;

    public Lesson() {}

    public Lesson(int day, int lessonNumber, String classroomNumber, Course course) {
        this.day = day;
        this.lessonNumber = lessonNumber;
        this.classroomNumber = classroomNumber;
        this.course = course;
    }
}
