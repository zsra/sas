package hu.zsra.enaplo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.model.user.group.Teacher;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Course model class contains information about the subject.
 */
@Entity
@Table(name = "courses")
public class Course {

    /**
     * Id field [GENERATED AUTOMATICALLY].
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Subject title.
     */
    @Column(name = "title", nullable = false, length = 24)
    private String title;

    /**
     * Subject year.
     */
    @Column(name = "year", nullable = false)
    private int year;

    /**
     * Empty constructor.
     */
    public Course() {}

    /**
     * Constructor to make a new instance.
     *
     * @param title Subject title.
     * @param year Subject year.
     * @param teacher Teacher who teach this subject.
     */
    public Course(String title, int year, Teacher teacher) {
        this.title = title;
        this.year = year;
        this.teacher = teacher;
    }

    /**
     * Teacher who teach this subject.
     */
    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    /**
     * Student who learn this subject.
     */
    @JsonIgnore
    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();

    /**
     * Exams that written by students.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<Exam> exams = new ArrayList<>();

    /**
     * Course time in Timetable.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<TimeTableEntity> lessons = new ArrayList<>();

    /**
     * Reports from this subject.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<Report> reports = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public List<TimeTableEntity> getLessons() {
        return lessons;
    }

    public void setLessons(List<TimeTableEntity> lessons) {
        this.lessons = lessons;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
