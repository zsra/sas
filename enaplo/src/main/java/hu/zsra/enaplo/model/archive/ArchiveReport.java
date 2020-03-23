package hu.zsra.enaplo.model.archive;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

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
    private Long id;

    /**
     * Course name.
     */
    @Column(name = "courseName", nullable = false)
    private String courseName;

    /**
     * Yeaar when course happens.
     */
    @Column(name = "year", nullable = false)
    private int year;

    /**
     * Final result at the end.
     */
    @Column(name = "mark", nullable = false)
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
    private Archive archive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArchiveReport that = (ArchiveReport) o;
        return year == that.year &&
                mark == that.mark &&
                Objects.equals(courseName, that.courseName) &&
                Objects.equals(archive, that.archive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, year, mark, archive);
    }
}
