package hu.zsra.enaplo.dto;

import hu.zsra.enaplo.model.user.group.Student;
import lombok.Getter;
import lombok.Setter;


public class AttendanceDTO {

    @Getter @Setter
    private Student student;
    @Getter @Setter
    private boolean isMiss;

    public  AttendanceDTO(Student student) {
        this.student = student;
        this.isMiss = false;
    }
}
