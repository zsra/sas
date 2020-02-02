package hu.zsra.enaplo.model.archive;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "archiveReports")
public class ArchiveReport {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(name = "courseName", nullable = false)
    @Getter @Setter
    private String courseName;

    @Column(name = "year", nullable = false)
    @Getter @Setter
    private int year;

    @Column(name = "mark", nullable = false)
    @Getter @Setter
    private int mark;

    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name="archive_id")
    @Getter @Setter
    private Archive archive;

    public ArchiveReport() {
    }

    public ArchiveReport(String courseName, int year, int mark, Archive archive) {
        this.courseName = courseName;
        this.year = year;
        this.mark = mark;
        this.archive = archive;
    }


}
