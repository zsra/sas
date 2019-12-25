package hu.zsra.enaplo.dto;

import lombok.Getter;
import lombok.Setter;

public class SummaryDTO {

    @Getter @Setter
    private String courseName;
    @Getter @Setter
    private int[] marks;
    @Getter @Setter
    private double average;

    public SummaryDTO(String courseName, int[] marks, double average) {
        this.courseName = courseName;
        this.marks = marks;
        this.average = average;
    }
}
