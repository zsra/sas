package hu.zsra.enaplo.dto.response;

import lombok.Getter;
import lombok.Setter;

public class TimeTableEntityResponseDTO {

    @Getter @Setter
    private int day;

    @Getter @Setter
    private int lessonNumber;

    @Getter @Setter
    private String classroomNumber;

    @Getter @Setter
    private Long course_id;

    @Getter @Setter
    private Long classroom_id;

    public TimeTableEntityResponseDTO() {
    }

    public TimeTableEntityResponseDTO(int day, int lessonNumber, String classroomNumber, Long course_id, Long classroom_id) {
        this.day = day;
        this.lessonNumber = lessonNumber;
        this.classroomNumber = classroomNumber;
        this.course_id = course_id;
        this.classroom_id = classroom_id;
    }
}
