package hu.zsra.enaplo.dto;

import hu.zsra.enaplo.dto.response.ReportResponseDTO;
import hu.zsra.enaplo.model.user.group.Student;
import lombok.Getter;
import lombok.Setter;

public class ReportDTO {

    @Getter @Setter
    private Student student;
    @Getter @Setter
    private ReportResponseDTO reportResponseDTO;

    public ReportDTO() {
    }

    public ReportDTO(Student student) {
        this.student = student;
        this.reportResponseDTO = new ReportResponseDTO();
    }
}