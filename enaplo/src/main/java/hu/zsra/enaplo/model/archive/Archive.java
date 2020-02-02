package hu.zsra.enaplo.model.archive;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "archives")
public class Archive {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(name = "username", nullable = false)
    @Getter @Setter
    private String username;

    @Column(name = "studentName", nullable = false)
    @Getter @Setter
    private String studentName;

    @Column(name = "dob", nullable = false)
    @Getter @Setter
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "archive")
    @Getter @Setter
    private List<ArchiveReport> reports;

    public Archive() {
    }

    public Archive(String username, String studentName, LocalDate dateOfBirth) {
        this.username = username;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
    }
}
