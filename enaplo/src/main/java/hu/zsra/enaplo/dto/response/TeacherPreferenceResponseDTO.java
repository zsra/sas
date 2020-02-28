package hu.zsra.enaplo.dto.response;

import lombok.Getter;
import lombok.Setter;

public class TeacherPreferenceResponseDTO {

    @Getter @Setter
    private Long teacher_id;

    @Getter @Setter
    private double testWeight;

    @Getter @Setter
    private double topicTestWeight;

    @Getter @Setter
    private double repetitionWeight;

    @Getter @Setter
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
}
