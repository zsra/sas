package hu.zsra.enaplo.dto;

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
    @Getter @Setter
    private String fullName;
    @Getter @Setter
    private String password;

    public TeacherResponseDTO() {}

    public TeacherResponseDTO(String username, String password, String email, String phone, String fullName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.fullName = fullName;
    }
}
