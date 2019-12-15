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
    private ReportType ReportType;

    @Column(name = "year", nullable = false)
    @Getter @Setter
    private int Year;

    @Column(name = "grade", nullable = false)
    @Getter @Setter
    private int Grade;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @Getter @Setter
    private Course Course;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @Getter @Setter
    private Student Student;

    public Report() {}

    public Report(hu.zsra.enaplo.model.report.ReportType reportType, int year, int grade,
                  Course course, Student student) {
        ReportType = reportType;
        Year = year;
        Grade = grade;
        Course = course;
        Student = student;
    }
}
