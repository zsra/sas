package hu.zsra.enaplo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.model.user.group.Teacher;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classroom is a group of students who are taught together at school. Classroom must has a
 * headteacher.
 */
@Entity
@Table(name = "classrooms")
public class Classroom {

    /**
     * Id field [GENERATED AUTOMATICALLY].
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Year when class started.
     */
    @Column(name = "start_year", nullable = false, length = 4)
    private int start_year;

    /**
     * Year when class will end.
     */
    @Column(name = "end_year", nullable = false, length = 4)
    private int end_year;

    /**
     * Current school year.
     */
    @Column(name = "year", nullable = false)
    private int year;

    /**
     * Class letter to identify the class in the school.
     */
    @Column(name = "letter", nullable = false, length = 1)
    private char letter;

    /**
     * Empty constructor.
     */
    public Classroom() {}

    /**
     * Constructor to make a new instance.
     *
     * @param start_year Year when class will end.
     * @param end_year Year when class will end.
     * @param year Current school year.
     * @param letter Class letter to identify the class in the school.
     * @param headTeacher The headteacher of the class.
     */
    public Classroom(int start_year, int end_year, int year, char letter, Teacher headTeacher) {
        this.start_year = start_year;
        this.end_year = end_year;
        this.year = year;
        this.letter = letter;
        this.headTeacher = headTeacher;
    }

    /**
     * The headteacher of the class.
     */
    @OneToOne
    private Teacher headTeacher;

    /**
     * Students who are taught together at school.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "classroom")
    private List<Student> students = new ArrayList<>();

    /**
     * Classroom Timetable.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "classroom")
    private List<TimeTableEntity> timeTableEntities = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStart_year() {
        return start_year;
    }

    public void setStart_year(int start_year) {
        this.start_year = start_year;
    }

    public int getEnd_year() {
        return end_year;
    }

    public void setEnd_year(int end_year) {
        this.end_year = end_year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public Teacher getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(Teacher headTeacher) {
        this.headTeacher = headTeacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<TimeTableEntity> getTimeTableEntities() {
        return timeTableEntities;
    }

    public void setTimeTableEntities(List<TimeTableEntity> timeTableEntities) {
        this.timeTableEntities = timeTableEntities;
    }
}
