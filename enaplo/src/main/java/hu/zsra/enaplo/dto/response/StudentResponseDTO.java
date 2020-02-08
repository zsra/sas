package hu.zsra.enaplo.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class StudentResponseDTO {

    @Getter @Setter
    private String username;
    @Getter @Setter
    private LocalDate dateOfBirth;
    @Getter @Setter
    private int start_year;
    @Getter @Setter
    private String address;
    @Getter @Setter
    private String gender;
    @Getter @Setter
    private String educationId;
    @Getter @Setter
    private String healthCareId;
    @Getter @Setter
    private String parent1Name;
    @Getter @Setter
    private String parent2Name;
    @Getter @Setter
    private String parent1Phone;
    @Getter @Setter
    private String parent2Phone;
    @JsonProperty("classroom_id")
    @Getter @Setter
    private Long classroom_id;

    public StudentResponseDTO() {}

    public StudentResponseDTO(String username, LocalDate dateOfBirth, int start_year, String address, String gender,
                              String educationId, String healthCareId, String parent1Name, String parent2Name,
                              String parent1Phone, String parent2Phone, Long classroom_id) {
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.start_year = start_year;
        this.address = address;
        this.gender = gender;
        this.educationId = educationId;
        this.healthCareId = healthCareId;
        this.parent1Name = parent1Name;
        this.parent2Name = parent2Name;
        this.parent1Phone = parent1Phone;
        this.parent2Phone = parent2Phone;
        this.classroom_id = classroom_id;
    }
}
