package hu.zsra.enaplo.dto;

import hu.zsra.enaplo.model.*;
import hu.zsra.enaplo.model.exam.Exam;
import hu.zsra.enaplo.model.user.Parent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class StudentDTO {

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String middleName;
    @Getter @Setter
    private String lastName;

    @Getter @Setter
    private LocalDate dateOfBirth;

    @Getter @Setter
    private String address;

    @Getter @Setter
    private String educationId;

    @Getter @Setter
    private String healthCareId;

    @Getter @Setter
    private Classroom classroom;

    @Getter @Setter
    private Set<Parent> parents = new HashSet<>();

    @Getter @Setter
    private Set<Course> courses = new HashSet<>();

    @Getter @Setter
    private Set<Exam> exams = new HashSet<>();

    @Getter @Setter
    private Set<Report> reports = new HashSet<>();

    @Getter @Setter
    private Set<Attendance> attendances = new HashSet<>();

    @Getter @Setter
    private Set<Remark> remarks= new HashSet<>();
}
