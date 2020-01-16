package hu.zsra.enaplo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "timeTables")
public class TimeTableEntity {

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

    @ManyToOne
    @JoinColumn(name="classroom_id")
    @Getter @Setter
    private Classroom classroom;

    public TimeTableEntity() {}

    public TimeTableEntity(int day, int lessonNumber, Course course, String classroomNumber, Classroom classroom) {
        this.day = day;
        this.lessonNumber = lessonNumber;
        this.course = course;
        this.classroomNumber = classroomNumber;
        this.classroom = classroom;
    }
}
