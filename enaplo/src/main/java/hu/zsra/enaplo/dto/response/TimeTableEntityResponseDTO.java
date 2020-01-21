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
    private long course_id;

    @Getter @Setter
    private long classroom_id;

    public TimeTableEntityResponseDTO() {
    }

    public TimeTableEntityResponseDTO(int day, int lessonNumber, String classroomNumber, long course_id, long classroom_id) {
        this.day = day;
        this.lessonNumber = lessonNumber;
        this.classroomNumber = classroomNumber;
        this.course_id = course_id;
        this.classroom_id = classroom_id;
    }
}
