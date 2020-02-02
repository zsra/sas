package hu.zsra.enaplo.repository.archive;

import hu.zsra.enaplo.model.archive.ArchiveReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchiveReportRepository extends JpaRepository<ArchiveReport, Long> {
}
