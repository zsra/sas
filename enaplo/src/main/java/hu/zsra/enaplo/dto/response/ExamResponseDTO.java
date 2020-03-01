package hu.zsra.enaplo.dto.response;

import java.time.LocalDate;

public class ExamResponseDTO {

    private int mark;

    private LocalDate written_at;

    private String examType;

    private Long course_id;

    private Long student_id;

    public ExamResponseDTO() {
    }

    public ExamResponseDTO(int mark, LocalDate written_at, String examType, Long course_id, Long student_id) {
        this.mark = mark;
        this.written_at = written_at;
        this.examType = examType;
        this.course_id = course_id;
        this.student_id = student_id;
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

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }
}
