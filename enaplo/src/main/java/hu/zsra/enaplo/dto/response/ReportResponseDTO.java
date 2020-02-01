package hu.zsra.enaplo.dto.response;

import lombok.Getter;
import lombok.Setter;

public class ReportResponseDTO {

    @Getter @Setter
    private int year;

    @Getter @Setter
    private int semester;

    @Getter @Setter
    private int mark;

    @Getter @Setter
    private Long student_id;

    @Getter @Setter
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
}
