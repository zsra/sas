package hu.zsra.enaplo.dto;

import lombok.Getter;
import lombok.Setter;

public class UserResponseDTO {

    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private String fullName;
    @Getter @Setter
    private String role;

    public UserResponseDTO() {
    }

    public UserResponseDTO(String username, String password, String fullName, String role) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }
}
