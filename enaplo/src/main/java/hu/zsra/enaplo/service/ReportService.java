package hu.zsra.enaplo.service;

import hu.zsra.enaplo.dto.ReportDTO;
import hu.zsra.enaplo.dto.response.ReportResponseDTO;
import hu.zsra.enaplo.model.Report;

import java.util.List;

/**
 * This interface contains all related function definitions to the report.
 */
public interface ReportService {

    /**
     * Returns a Summary of semester for student. One
     * Report object is a course-mark pair. Each report made by
     * Teacher.
     *
     * @param student_id Id of the student.
     * @param year The year when semester was.
     * @param semester Semester when report made.
     * @return List of the reports.
     */
    List<Report> getSemesterResultByStudent(Long student_id, int year, int semester);

    /**
     * Returns a Report object by id.
     *
     * @param id Id of the Course.
     * @return a report object.
     */
    Report findById(Long id);

    /**
     * Creates a new report and save into the database.
     *
     * @param reportResponseDTO Submitted DTO from web application.
     * @return  a new Report object.
     * @see Report
     */
    Report create(ReportResponseDTO reportResponseDTO);

    /**
     * Updates a report from database by id.
     *
     * @param id Id of the report.
     * @param reportResponseDTO Submitted DTO from web application.
     * @return an updated report.
     * @see Report
     */
    Report update(Long id, ReportResponseDTO reportResponseDTO);

    /**
     * Deletes a report from database by id.
     *
     * @param id Id of the report.
     */
    void delete(Long id);

    /**
     * Returns a form that contains a list of students
     * and mark field for each student.
     *
     * @param classroom_id Id of the classroom.
     * @return A form table to create reports to all student in classroom.
     */
    List<ReportDTO> makeReportFormToClassroom(Long classroom_id);

    /**
     * Creates a new reports and save into the database.
     *
     * @param reportResponseDTOS Submitted DTOs from web application.
     * @return  a new Report objects.
     * @see Report
     */
    List<Report> createReportsToClassroom(List<ReportResponseDTO> reportResponseDTOS);
}
