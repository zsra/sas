package hu.zsra.enaplo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.model.user.group.Teacher;
import lombok.Getter;
import lombok.Setter;

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
    @Getter @Setter
    private Long id;

    /**
     * Year when class started.
     */
    @Column(name = "start_year", nullable = false, length = 4)
    @Getter @Setter
    private int start_year;

    /**
     * Year when class will end.
     */
    @Column(name = "end_year", nullable = false, length = 4)
    @Getter @Setter
    private int end_year;

    /**
     * Current school year.
     */
    @Column(name = "year", nullable = false)
    @Getter @Setter
    private int year;

    /**
     * Class letter to identify the class in the school.
     */
    @Column(name = "letter", nullable = false, length = 1)
    @Getter @Setter
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
    @Getter @Setter
    private Teacher headTeacher;

    /**
     * Students who are taught together at school.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "classroom")
    @Getter @Setter
    private List<Student> students = new ArrayList<>();

    /**
     * Classroom Timetable.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "classroom")
    @Getter @Setter
    private List<TimeTableEntity> timeTableEntities = new ArrayList<>();
}
