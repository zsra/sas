package hu.zsra.enaplo.dto;

import hu.zsra.enaplo.model.user.Role;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

public class UserDTO {

    @Getter @Setter
    private String Username;
    @Getter @Setter
    private String Password;

    @Getter @Setter
    private String FirstName;
    @Getter @Setter
    private String MiddleName;
    @Getter @Setter
    private String LastName;
    @Getter @Setter
    private Date DateOfBirth;

    @Getter @Setter
    private Role Role;

    @Getter @Setter
    private Boolean Status;
    @Getter @Setter
    private Date LastLogin;
}
