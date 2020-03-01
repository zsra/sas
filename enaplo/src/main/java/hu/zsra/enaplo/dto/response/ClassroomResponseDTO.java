package hu.zsra.enaplo.dto.response;

public class ClassroomResponseDTO {

    private int start_year;

    private int end_year;

    private int year;

    private char letter;

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

    public int getStart_year() {
        return start_year;
    }

    public void setStart_year(int start_year) {
        this.start_year = start_year;
    }

    public int getEnd_year() {
        return end_year;
    }

    public void setEnd_year(int end_year) {
        this.end_year = end_year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public Long getHeadTeacher_id() {
        return headTeacher_id;
    }

    public void setHeadTeacher_id(Long headTeacher_id) {
        this.headTeacher_id = headTeacher_id;
    }
}
