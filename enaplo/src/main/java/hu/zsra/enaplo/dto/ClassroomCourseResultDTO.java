package hu.zsra.enaplo.dto;

import hu.zsra.enaplo.model.Course;

public class ClassroomCourseResultDTO {

    private Course course;

    private double result;

    public ClassroomCourseResultDTO() {
    }

    public ClassroomCourseResultDTO(Course course, double result) {
        this.course = course;
        this.result = result;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
