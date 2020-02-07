package hu.zsra.enaplo.model.archive;

import lombok.Getter;
import lombok.Setter;

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
    @Getter @Setter
    private Long id;

    /**
     * Student Login username.
     */
    @Column(name = "username", nullable = false)
    @Getter @Setter
    private String username;

    /**
     * Student fulla name.
     */
    @Column(name = "studentName", nullable = false)
    @Getter @Setter
    private String studentName;

    /**
     * Student date of birth.
     */
    @Column(name = "dob", nullable = false)
    @Getter @Setter
    private LocalDate dateOfBirth;

    /**
     * All reports to student.
     */
    @OneToMany(mappedBy = "archive", cascade=CascadeType.ALL)
    @Getter @Setter
    private List<ArchiveReport> reports;

    /**
     * Empty Constructor.
     */
    public Archive() {
    }

    /**
     * Constructor to make a new instance.
     * 
     * @param username Student login username.
     * @param studentName Student fullname.
     * @param dateOfBirth Student date of birth.
     */
    public Archive(String username, String studentName, LocalDate dateOfBirth) {
        this.username = username;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
    }
}
