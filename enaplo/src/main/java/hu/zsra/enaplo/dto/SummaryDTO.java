package hu.zsra.enaplo.dto;

import hu.zsra.enaplo.model.Exam;

import java.util.List;

public class SummaryDTO {

    private String courseName;
    private List<Exam> exams;
    private double average;

    public SummaryDTO(String title, List<Exam> exams, double average) {
        this.courseName = title;
        this.exams = exams;
        this.average = average;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
