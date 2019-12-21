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
    private Teacher teacher;

    @OneToOne(mappedBy = "headTeacher")
    @Getter @Setter
    private Classroom classroom;

    public HeadTeacher() {
        classroom = null;
    }

    public HeadTeacher(Teacher teacher) {
        this.teacher = teacher;
        teacher.getUser().setRole(Role.ROLE_HEAD_TEACHER);
        this.classroom = null;
    }
}
