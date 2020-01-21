package hu.zsra.enaplo.dto.response;

import lombok.Getter;
import lombok.Setter;

public class ClassroomResponseDTO {

    @Getter @Setter
    private int start_year;

    @Getter @Setter
    private int end_year;

    @Getter @Setter
    private int year;

    @Getter @Setter
    private char letter;

    @Getter @Setter
    private Long headTeacher_id;

    public ClassroomResponseDTO() {
    }

    public ClassroomResponseDTO(int start_year, int end_year, int year, char letter, Long headTeacher_id) {
        this.start_year = start_year;
        this.end_year = end_year;
        this.year = year;
        this.letter = letter;
        this.headTeacher_id = headTeacher_id;
    }
}
