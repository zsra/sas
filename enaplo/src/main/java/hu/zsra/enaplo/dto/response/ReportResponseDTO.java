package hu.zsra.enaplo.dto.response;

public class ReportResponseDTO {

    private int year;

    private int semester;

    private int mark;

    private Long student_id;

    private Long course_id;

    public ReportResponseDTO() {
    }

    public ReportResponseDTO(int year, int semester, int mark, Long student_id, Long course_id) {
        this.year = year;
        this.semester = semester;
        this.mark = mark;
        this.student_id = student_id;
        this.course_id = course_id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }
}
