package hu.zsra.enaplo.model;

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
    private Long id;

    /**
     * Day when course hold.
     */
    @Column(name = "day", nullable = false)
    private int day;

    /**
     * Time when course hold.
     */
    @Column(name = "lesson", nullable = false)
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
    private Course course;

    /**
     * The class.
     */
    @ManyToOne
    @JoinColumn(name="classroom_id")
    private Classroom classroom;

    /**
     * User object to room. This property connects the room to
     * the lesson.
     */
    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
