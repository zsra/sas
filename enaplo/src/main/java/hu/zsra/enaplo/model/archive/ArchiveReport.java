package hu.zsra.enaplo.model.archive;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * This class represent an archived report. !ONLY THE END YEAR RESULT!
 */
@Entity
@Table(name = "archiveReports")
public class ArchiveReport {

    /**
     * Id field [GENERATED AUTOMATICALLY].
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    /**
     * Course name.
     */
    @Column(name = "courseName", nullable = false)
    @Getter @Setter
    private String courseName;

    /**
     * Yeaar when course happens.
     */
    @Column(name = "year", nullable = false)
    @Getter @Setter
    private int year;

    /**
     * Final result at the end.
     */
    @Column(name = "mark", nullable = false)
    @Getter @Setter
    private int mark;

    /**
     * Empty constructor
     */
    public ArchiveReport() {
    }

    /**
     * Constructor to make a new instance.
     * 
     * @param courseName Course name. 
     * @param year Year when course happens.
     * @param mark Final result at the end.
     * @param archive Student object to collect reports.
     */
    public ArchiveReport(String courseName, int year, int mark, Archive archive) {
        this.courseName = courseName;
        this.year = year;
        this.mark = mark;
        this.archive = archive;
    }

    /**
     * Connects the report to the student.
     */
    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name="archive_id")
    @Getter @Setter
    private Archive archive;
}
