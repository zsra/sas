package hu.zsra.enaplo.dto;

import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.user.group.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class FailedStudentDTO {

    @Getter
    @Setter
    private Student student;

    @Getter
    @Setter
    private List<Course> courses;

    public FailedStudentDTO() {
    }

    public FailedStudentDTO(Student student, List<Course> courses) {
        this.student = student;
        this.courses = courses;
    }
}
