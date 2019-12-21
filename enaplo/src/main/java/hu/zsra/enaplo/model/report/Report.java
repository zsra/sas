package hu.zsra.enaplo.model.report;

import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.user.Student;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(name = "report_type", length = 32, nullable = false)
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private ReportType reportType;

    @Column(name = "year", nullable = false)
    @Getter @Setter
    private int year;

    @Column(name = "grade", nullable = false)
    @Getter @Setter
    private int grade;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @Getter @Setter
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @Getter @Setter
    private Student student;

    public Report() {}

    public Report(hu.zsra.enaplo.model.report.ReportType reportType, int year, int grade,
                  Course course, Student student) {
        this.reportType = reportType;
        this.year = year;
        this.grade = grade;
        this.course = course;
        this.student = student;
    }
}
