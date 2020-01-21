package hu.zsra.enaplo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.model.user.group.Teacher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(name = "start_year", nullable = false, length = 4)
    @Getter @Setter
    private int start_year;

    @Column(name = "end_year", nullable = false, length = 4)
    @Getter @Setter
    private int end_year;

    @Column(name = "year", nullable = false)
    @Getter @Setter
    private int year;

    @Column(name = "letter", nullable = false, length = 1)
    @Getter @Setter
    private char letter;

    @OneToOne
    @Getter @Setter
    private Teacher headTeacher;

    public Classroom() {}

    public Classroom(int start_year, int end_year, int year, char letter, Teacher headTeacher) {
        this.start_year = start_year;
        this.end_year = end_year;
        this.year = year;
        this.letter = letter;
        this.headTeacher = headTeacher;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "classroom")
    @Getter @Setter
    private List<Student> students = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "classroom")
    @Getter @Setter
    private List<TimeTableEntity> timeTableEntities = new ArrayList<>();


}
