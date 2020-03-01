package hu.zsra.enaplo.model;

import hu.zsra.enaplo.model.user.group.Teacher;

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
    private Long id;

    /**
     * Teacher who own the preferences.
     */
    @OneToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    /**
     * Weight of the test.
     */
    private double testWeight;

    /**
     * Weight of the topic test.
     */
    private double topicTestWeight;

    /**
     * Weight of the repetition.
     */
    private double repetitionWeight;

    /**
     * Weight of the homework.
     */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public double getTestWeight() {
        return testWeight;
    }

    public void setTestWeight(double testWeight) {
        this.testWeight = testWeight;
    }

    public double getTopicTestWeight() {
        return topicTestWeight;
    }

    public void setTopicTestWeight(double topicTestWeight) {
        this.topicTestWeight = topicTestWeight;
    }

    public double getRepetitionWeight() {
        return repetitionWeight;
    }

    public void setRepetitionWeight(double repetitionWeight) {
        this.repetitionWeight = repetitionWeight;
    }

    public double getHomeworkWeight() {
        return homeworkWeight;
    }

    public void setHomeworkWeight(double homeworkWeight) {
        this.homeworkWeight = homeworkWeight;
    }
}
