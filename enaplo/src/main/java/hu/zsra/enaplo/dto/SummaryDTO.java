package hu.zsra.enaplo.dto;

import hu.zsra.enaplo.model.Exam;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class SummaryDTO {

    @Getter @Setter
    private String courseName;
    @Getter @Setter
    private List<Exam> exams;
    @Getter @Setter
    private double average;

    public SummaryDTO(String title, List<Exam> exams, double average) {
        this.courseName = title;
        this.exams = exams;
        this.average = average;
    }
}
