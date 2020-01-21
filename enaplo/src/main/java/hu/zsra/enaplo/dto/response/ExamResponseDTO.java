package hu.zsra.enaplo.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class ExamResponseDTO {

    @Getter @Setter
    private int mark;

    @Getter @Setter
    private LocalDate writtenAt;

    @Getter @Setter
    private Long course_id;

    @Getter @Setter
    private Long student_id;

    public ExamResponseDTO() {
    }

    public ExamResponseDTO(int mark, LocalDate writtenAt, Long course_id, Long student_id) {
        this.mark = mark;
        this.writtenAt = writtenAt;
        this.course_id = course_id;
        this.student_id = student_id;
    }
}
