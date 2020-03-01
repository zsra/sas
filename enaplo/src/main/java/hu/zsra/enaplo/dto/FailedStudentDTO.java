package hu.zsra.enaplo.dto;

import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.user.group.Student;

import java.util.List;

public class FailedStudentDTO {

    private Student student;

    private List<Course> courses;

    public FailedStudentDTO() {
    }

    public FailedStudentDTO(Student student, List<Course> courses) {
        this.student = student;
        this.courses = courses;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
