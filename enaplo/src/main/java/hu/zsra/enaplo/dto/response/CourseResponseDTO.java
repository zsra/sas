package hu.zsra.enaplo.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class CourseResponseDTO {

    @Getter @Setter
    private String title;

    @Getter @Setter
    private int year;

    @Getter @Setter
    private Long teacher_id;

    public CourseResponseDTO() {
    }

    public CourseResponseDTO(String title, int year, Long teacher_id) {
        this.title = title;
        this.year = year;
        this.teacher_id = teacher_id;
    }
}
