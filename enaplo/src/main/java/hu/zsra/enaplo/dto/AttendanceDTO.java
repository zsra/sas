package hu.zsra.enaplo.dto;

import hu.zsra.enaplo.model.user.group.Student;

public class AttendanceDTO {

    private Student student;
    private boolean isMiss;

    public  AttendanceDTO(Student student) {
        this.student = student;
        this.isMiss = false;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isMiss() {
        return isMiss;
    }

    public void setMiss(boolean miss) {
        isMiss = miss;
    }
}
