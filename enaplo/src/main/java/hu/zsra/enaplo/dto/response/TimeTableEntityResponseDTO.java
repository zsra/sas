package hu.zsra.enaplo.dto.response;

public class TimeTableEntityResponseDTO {

    private int day;

    private int lessonNumber;

    private Long room_id;

    private Long course_id;

    private Long classroom_id;

    public TimeTableEntityResponseDTO() {
    }

    public TimeTableEntityResponseDTO(int day, int lessonNumber, Long room_id, Long course_id, Long classroom_id) {
        this.day = day;
        this.lessonNumber = lessonNumber;
        this.room_id = room_id;
        this.course_id = course_id;
        this.classroom_id = classroom_id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public Long getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(Long classroom_id) {
        this.classroom_id = classroom_id;
    }
}
