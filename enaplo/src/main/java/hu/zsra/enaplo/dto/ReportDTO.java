package hu.zsra.enaplo.dto;

import hu.zsra.enaplo.model.user.group.Student;

public class ReportDTO {

    private Student student;
    private int mark;

    public ReportDTO() {
    }

    public ReportDTO(Student student) {
        this.student = student;
        this.mark = 0;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
