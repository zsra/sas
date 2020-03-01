package hu.zsra.enaplo.dto.response;

public class RemarkResponseDTO {

    private String text;

    private Long student_id;

    public RemarkResponseDTO(String text, Long student_id) {
        this.text = text;
        this.student_id = student_id;

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }
}
