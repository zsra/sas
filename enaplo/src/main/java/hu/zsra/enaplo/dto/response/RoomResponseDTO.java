package hu.zsra.enaplo.dto.response;

import lombok.Getter;
import lombok.Setter;

public class RoomResponseDTO {

    @Getter
    @Setter
    private String classroomNumber;

    public RoomResponseDTO() {
    }

    public RoomResponseDTO(String classroomNumber) {
        this.classroomNumber = classroomNumber;
    }
}
