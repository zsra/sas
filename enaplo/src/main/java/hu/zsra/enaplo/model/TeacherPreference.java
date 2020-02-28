package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.group.Teacher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * TeacherPreference model to store the Teacher preferences for weighting the exams.
 */
@Entity
@Table(name = "teacher_preferences")
public class TeacherPreference {

    /**
     * Id field [GENERATED AUTOMATICALLY].
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    /**
     * Teacher who own the preferences.
     */
    @OneToOne
    @JoinColumn(name="teacher_id")
    @Getter @Setter
    private Teacher teacher;

    /**
     * Weight of the test.
     */
    @Getter @Setter
    private double testWeight;

    /**
     * Weight of the topic test.
     */
    @Getter @Setter
    private double topicTestWeight;

    /**
     * Weight of the repetition.
     */
    @Getter @Setter
    private double repetitionWeight;

    /**
     * Weight of the homework.
     */
    @Getter @Setter
    private double homeworkWeight;

    /**
     * Empty constructor.
     */
    public TeacherPreference() {
    }

    /**
     * Constructor to make a new instance.
     *
     * @param teacher Teacher who own the preferences.
     * @param testWeight Weight of the test.
     * @param topicTestWeight Weight of the topic test.
     * @param repetitionWeight Weight of the repetition.
     * @param homeworkWeight Weight of the homework.
     */
    public TeacherPreference(Teacher teacher, double testWeight, double topicTestWeight, double repetitionWeight, double homeworkWeight) {
        this.teacher = teacher;
        this.testWeight = testWeight;
        this.topicTestWeight = topicTestWeight;
        this.repetitionWeight = repetitionWeight;
        this.homeworkWeight = homeworkWeight;
    }
}
