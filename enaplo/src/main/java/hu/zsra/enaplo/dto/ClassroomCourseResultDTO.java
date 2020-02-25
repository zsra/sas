package hu.zsra.enaplo.dto;

import hu.zsra.enaplo.model.Course;
import lombok.Getter;
import lombok.Setter;

public class ClassroomCourseResultDTO {

    @Getter
    @Setter
    private Course course;

    @Getter
    @Setter
    private double result;

    public ClassroomCourseResultDTO() {
    }

    public ClassroomCourseResultDTO(Course course, double result) {
        this.course = course;
        this.result = result;
    }
}
