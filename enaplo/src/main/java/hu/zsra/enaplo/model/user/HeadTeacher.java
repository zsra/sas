package hu.zsra.enaplo.model.user;

import hu.zsra.enaplo.model.Classroom;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "head_teacher")
public class HeadTeacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    /* Relationships */

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    @Getter @Setter
    private Teacher Teacher;

    @OneToOne(mappedBy = "HeadTeacher")
    @Getter @Setter
    private Classroom Classroom;

    public HeadTeacher() {
        Classroom = null;
    }

    public HeadTeacher(Teacher teacher) {
        Teacher = teacher;
        Teacher.getUser().setRole(Role.ROLE_HEAD_TEACHER);
        Classroom = null;
    }
}
