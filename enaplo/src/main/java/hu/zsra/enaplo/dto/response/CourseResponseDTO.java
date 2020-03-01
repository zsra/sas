package hu.zsra.enaplo.dto.response;

public class CourseResponseDTO {

    private String title;

    private int year;

    private Long teacher_id;

    public CourseResponseDTO() {
    }

    public CourseResponseDTO(String title, int year, Long teacher_id) {
        this.title = title;
        this.year = year;
        this.teacher_id = teacher_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }
}
