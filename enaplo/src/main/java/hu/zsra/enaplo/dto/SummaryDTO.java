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

    public SummaryDTO(String title, int[] toArray, double average) {
        this.courseName = title;
        this.marks = toArray;
        this.average = average;
    }
}
