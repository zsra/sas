package hu.zsra.enaplo.dto.response;

import hu.zsra.enaplo.dto.AttendanceDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

public class AttendanceResponseDTO {

    @Getter @Setter
    private List<AttendanceDTO> attendanceDTO;

    @Getter @Setter
    private int lesson;

    @Getter @Setter
    private LocalDate dateOfMiss;

    public AttendanceResponseDTO() {
    }

    public AttendanceResponseDTO(List<AttendanceDTO> attendanceDTO, int lesson, LocalDate dateOfMiss) {
        this.attendanceDTO = attendanceDTO;
        this.lesson = lesson;
        this.dateOfMiss = dateOfMiss;
    }
}
