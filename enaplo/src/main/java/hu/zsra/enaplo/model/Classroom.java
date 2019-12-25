package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.Student;
import hu.zsra.enaplo.model.user.Teacher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "classrooms")
public class Classroom {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "classroom")
    @Getter @Setter
    private Set<Student> students = new HashSet<>();

    public Classroom() {}

    public Classroom(int start_year, int end_year, int year, char letter, Teacher headTeacher) {
        this.start_year = start_year;
        this.end_year = end_year;
        this.year = year;
        this.letter = letter;
        this.headTeacher = headTeacher;
    }
}
