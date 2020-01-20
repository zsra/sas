package hu.zsra.enaplo.dto;

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
    private String educationId;
    @Getter @Setter
    private String healthCareId;
    @Getter @Setter
    private String parent1Name;
    @Getter @Setter
    private String parent2Name;
    @JsonProperty("classroom_id")
    @Getter @Setter
    private Long classroom_id;

    public StudentResponseDTO() {}

    public StudentResponseDTO(String username, LocalDate dateOfBirth, int start_year, String address,
                              String educationId, String healthCareId, String parent1Name, String parent2Name,
                              Long classroom_id) {
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.start_year = start_year;
        this.address = address;
        this.educationId = educationId;
        this.healthCareId = healthCareId;
        this.parent1Name = parent1Name;
        this.parent2Name = parent2Name;
        this.classroom_id = classroom_id;
    }
}
