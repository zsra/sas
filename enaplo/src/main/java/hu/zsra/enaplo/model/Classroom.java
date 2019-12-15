package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.*;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "classroom")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(name = "year", nullable = false)
    @Getter @Setter
    private int Year;

    @Column(name = "letter", nullable = false)
    @Getter @Setter
    private char Letter;

    /* Relationships */

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "head_teacher_id", referencedColumnName = "id")
    @Getter @Setter
    private HeadTeacher HeadTeacher;

    @ManyToMany
    @Getter @Setter
    private Set<Student> Students;

    public Classroom() {}

    public Classroom(int year, char letter) {
        Year = year;
        Letter = letter;
        HeadTeacher = null;
        Students = new HashSet<>();
    }
}
