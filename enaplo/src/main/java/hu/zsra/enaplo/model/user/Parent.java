package hu.zsra.enaplo.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "parents")
public class Parent extends User {

    @Column(name = "firstName", nullable = false, length = 24)
    @Getter @Setter
    private String firstName;

    @Column(name = "middleName", length = 24)
    @Getter @Setter
    private String middleName;

    @Column(name = "lastName", nullable = false, length = 24)
    @Getter @Setter
    private String lastName;

    @Column(name = "dob", nullable = false)
    @Getter @Setter
    private LocalDate dateOfBirth;

    @Column(name = "email", length = 64)
    @Getter @Setter
    private String email;

    @Column(name = "phone", nullable = false, length = 16)
    @Getter @Setter
    private String phone;

    @JsonIgnore
    @ManyToMany(mappedBy = "parents")
    @Getter @Setter
    private Set<Student> kids = new HashSet<>();

    public Parent() {}

    public Parent(String username, String password, String firstName, String middleName,
                  String lastName, LocalDate dateOfBirth, String email, String phone) {
        super(username, password, Role.ROLE_PARENT);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phone = phone;
    }
}
