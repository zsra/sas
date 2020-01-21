package hu.zsra.enaplo.dto;

import hu.zsra.enaplo.dto.response.ExamResponseDTO;
import hu.zsra.enaplo.model.user.group.Student;
import lombok.Getter;
import lombok.Setter;

public class ExamDTO {

    @Getter @Setter
    private Student student;

    @Getter @Setter
    private ExamResponseDTO examResponseDTO;

    public ExamDTO() {
    }

    public ExamDTO(Student student) {
        this.student = student;
        this.examResponseDTO = new ExamResponseDTO();
    }
}
