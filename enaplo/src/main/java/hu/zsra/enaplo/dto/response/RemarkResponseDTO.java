package hu.zsra.enaplo.dto.response;

import lombok.Getter;
import lombok.Setter;

public class RemarkResponseDTO {

    @Getter @Setter
    private String text;

    @Getter @Setter
    private Long student_id;

    public RemarkResponseDTO(String text, Long student_id) {
        this.text = text;
        this.student_id = student_id;

    }
}
