package hu.zsra.enaplo.dto.response;

import lombok.Getter;
import lombok.Setter;

public class
TeacherResponseDTO {

    @Getter @Setter
    private String username;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String phone;

    public TeacherResponseDTO() {}

    public TeacherResponseDTO(String username, String email, String phone) {
        this.username = username;
        this.email = email;
        this.phone = phone;
    }
}
