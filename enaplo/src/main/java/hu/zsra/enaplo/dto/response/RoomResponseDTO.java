package hu.zsra.enaplo.dto.response;

public class RoomResponseDTO {

    private String classroomNumber;

    public RoomResponseDTO() {
    }

    public RoomResponseDTO(String classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    public String getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(String classroomNumber) {
        this.classroomNumber = classroomNumber;
    }
}
