package hu.zsra.enaplo.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class StudentResponseDTO {

    private String username;

    private LocalDate dateOfBirth;

    private int start_year;

    private String address;

    private String gender;

    private String educationId;

    private String healthCareId;

    private String parent1Name;

    private String parent2Name;

    private String parent1Phone;

    private String parent2Phone;

    @JsonProperty("classroom_id")
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getStart_year() {
        return start_year;
    }

    public void setStart_year(int start_year) {
        this.start_year = start_year;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducationId() {
        return educationId;
    }

    public void setEducationId(String educationId) {
        this.educationId = educationId;
    }

    public String getHealthCareId() {
        return healthCareId;
    }

    public void setHealthCareId(String healthCareId) {
        this.healthCareId = healthCareId;
    }

    public String getParent1Name() {
        return parent1Name;
    }

    public void setParent1Name(String parent1Name) {
        this.parent1Name = parent1Name;
    }

    public String getParent2Name() {
        return parent2Name;
    }

    public void setParent2Name(String parent2Name) {
        this.parent2Name = parent2Name;
    }

    public String getParent1Phone() {
        return parent1Phone;
    }

    public void setParent1Phone(String parent1Phone) {
        this.parent1Phone = parent1Phone;
    }

    public String getParent2Phone() {
        return parent2Phone;
    }

    public void setParent2Phone(String parent2Phone) {
        this.parent2Phone = parent2Phone;
    }

    public Long getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(Long classroom_id) {
        this.classroom_id = classroom_id;
    }
}
