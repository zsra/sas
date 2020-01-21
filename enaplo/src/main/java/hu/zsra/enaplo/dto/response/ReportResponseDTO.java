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
    private long student_id;
}
