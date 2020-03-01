package hu.zsra.enaplo.dto;

import hu.zsra.enaplo.model.user.group.Student;

import java.time.LocalDate;

public class ExamDTO {

    private Student student;

    private int mark;

    private LocalDate written_at;

    private String examType;

    public ExamDTO() {
    }

    public ExamDTO(Student student, LocalDate written_at, String examType) {
        this.student = student;
        this.mark = 0;
        this.written_at = written_at;
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

    public LocalDate getWritten_at() {
        return written_at;
    }

    public void setWritten_at(LocalDate written_at) {
        this.written_at = written_at;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }
}
