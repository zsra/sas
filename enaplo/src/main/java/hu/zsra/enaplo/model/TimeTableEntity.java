package hu.zsra.enaplo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Timetable for students and teachers.
 */
@Entity
@Table(name = "timeTables")
public class TimeTableEntity {

    /**
     * Id field [GENERATED AUTOMATICALLY].
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    /**
     * Day when course hold.
     */
    @Column(name = "day", nullable = false)
    @Getter @Setter
    private int day;

    /**
     * Time when course hold.
     */
    @Column(name = "lesson", nullable = false)
    @Getter @Setter
    private int lessonNumber;

    /**
     * Empty constructor.
     */
    public TimeTableEntity() {}

    /**
     * Constructor to make a new instance.
     *
     * @param day Day when course hold.
     * @param lessonNumber Time when course hold.
     * @param course The course.
     * @param classroom The class.
     */
    public TimeTableEntity(int day, int lessonNumber, Room room, Course course, Classroom classroom) {
        this.day = day;
        this.lessonNumber = lessonNumber;
        this.room = room;
        this.course = course;
        this.classroom = classroom;
    }

    /**
     * The course.
     */
    @ManyToOne
    @Getter @Setter
    private Course course;

    /**
     * The class.
     */
    @ManyToOne
    @JoinColumn(name="classroom_id")
    @Getter @Setter
    private Classroom classroom;

    /**
     * User object to room. This property connects the room to
     * the lesson.
     */
    @ManyToOne
    @JoinColumn(name="room_id")
    @Getter @Setter
    private Room room;
}
