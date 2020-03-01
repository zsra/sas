package hu.zsra.enaplo.dto.response;

public class TeacherPreferenceResponseDTO {

    private Long teacher_id;

    private double testWeight;

    private double topicTestWeight;

    private double repetitionWeight;

    private double homeworkWeight;

    public TeacherPreferenceResponseDTO(Long teacher_id, double testWeight, double topicTestWeight, double repetitionWeight, double homeworkWeight) {
        this.teacher_id = teacher_id;
        this.testWeight = testWeight;
        this.topicTestWeight = topicTestWeight;
        this.repetitionWeight = repetitionWeight;
        this.homeworkWeight = homeworkWeight;

    }

    public TeacherPreferenceResponseDTO() {
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
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
