package hu.zsra.enaplo.dto;

import hu.zsra.enaplo.model.user.group.Student;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class ExamDTO {

    @Getter @Setter
    private Student student;

    @Getter @Setter
    private int mark;

    @Getter @Setter
    private LocalDate written_at;

    public ExamDTO() {
    }

    public ExamDTO(Student student, LocalDate written_at) {
        this.student = student;
        this.mark = 0;
        this.written_at = written_at;
    }
}
