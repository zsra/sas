package hu.zsra.enaplo.model.archive;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Archive object to store student data and there reports from pass.
 */
@Entity
@Table(name = "archives")
public class Archive {

    /**
     * Id field [GENERATED AUTOMATICALLY].
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Student Login username.
     */
    @Column(name = "username", nullable = false)
    private String username;

    /**
     * Student full name.
     */
    @Column(name = "studentName", nullable = false)
    private String studentName;

    /**
     * Student date of birth.
     */
    @Column(name = "dob", nullable = false)
    private LocalDate dateOfBirth;

    /**
     * Empty Constructor.
     */
    public Archive() {
    }

    /**
     * Constructor to make a new instance.
     * 
     * @param username Student login username.
     * @param studentName Student full name.
     * @param dateOfBirth Student date of birth.
     */
    public Archive(String username, String studentName, LocalDate dateOfBirth) {
        this.username = username;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * All reports to student.
     */
    @OneToMany(mappedBy = "archive", cascade=CascadeType.ALL)
    private List<ArchiveReport> reports;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<ArchiveReport> getReports() {
        return reports;
    }

    public void setReports(List<ArchiveReport> reports) {
        this.reports = reports;
    }
}
