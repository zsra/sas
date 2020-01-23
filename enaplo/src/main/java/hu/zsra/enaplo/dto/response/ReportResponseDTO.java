package hu.zsra.enaplo.dto.response;

import lombok.Getter;
import lombok.Setter;

public class ReportResponseDTO {

    @Getter @Setter
    private int year;

    @Getter @Setter
    private int semester;

    @Getter @Setter
    private String courseName;

    @Getter @Setter
    private int mark;

    @Getter @Setter
    private Long student_id;

    public ReportResponseDTO() {
    }

    public ReportResponseDTO(int year, int semester, String courseName, int mark, Long student_id) {
        this.year = year;
        this.semester = semester;
        this.courseName = courseName;
        this.mark = mark;
        this.student_id = student_id;
    }
}
