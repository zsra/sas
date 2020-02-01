package hu.zsra.enaplo.dto.response;

import hu.zsra.enaplo.dto.AttendanceDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

public class AttendanceResponseDTO {

    @Getter @Setter
    private Long student_id;

    @Getter @Setter
    private boolean miss;

    @Getter @Setter
    private int lesson;

    @Getter @Setter
    private LocalDate dateOfMiss;

    public AttendanceResponseDTO() {
    }

    public AttendanceResponseDTO(Long student_id,boolean miss, int lesson, LocalDate dateOfMiss) {
        this.student_id = student_id;
        this.miss = miss;
        this.lesson = lesson;
        this.dateOfMiss = dateOfMiss;
    }
}
