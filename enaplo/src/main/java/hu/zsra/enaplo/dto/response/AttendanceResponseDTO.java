package hu.zsra.enaplo.dto.response;

import java.time.LocalDate;

public class AttendanceResponseDTO {

    private Long student_id;

    private boolean miss;

    private int lesson;

    private LocalDate dateOfMiss;

    public AttendanceResponseDTO() {
    }

    public AttendanceResponseDTO(Long student_id, boolean miss, int lesson, LocalDate dateOfMiss) {
        this.student_id = student_id;
        this.miss = miss;
        this.lesson = lesson;
        this.dateOfMiss = dateOfMiss;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public boolean isMiss() {
        return miss;
    }

    public void setMiss(boolean miss) {
        this.miss = miss;
    }

    public int getLesson() {
        return lesson;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }

    public LocalDate getDateOfMiss() {
        return dateOfMiss;
    }

    public void setDateOfMiss(LocalDate dateOfMiss) {
        this.dateOfMiss = dateOfMiss;
    }
}
