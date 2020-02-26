package hu.zsra.enaplo.service.impl;

import hu.zsra.enaplo.model.Classroom;
import hu.zsra.enaplo.model.Report;
import hu.zsra.enaplo.model.archive.Archive;
import hu.zsra.enaplo.model.archive.ArchiveReport;
import hu.zsra.enaplo.model.user.Authority;
import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.repository.*;
import hu.zsra.enaplo.repository.archive.ArchiveReportRepository;
import hu.zsra.enaplo.repository.archive.ArchiveRepository;
import hu.zsra.enaplo.repository.user.StudentRepository;
import hu.zsra.enaplo.repository.user.TeacherRepository;
import hu.zsra.enaplo.repository.user.UserRepository;
import hu.zsra.enaplo.service.AdminService;
import hu.zsra.enaplo.service.auth.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class contains all related function implementations to the admin.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private TimeTableRepository timeTableRepository;
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private ArchiveReportRepository archiveReportRepository;
    @Autowired
    private ArchiveRepository archiveRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    private AuthorityService authService;
    @Autowired
    private RemarkRepository remarkRepository;

    /**
     * When the school year ends, the admin able to update the
     * entire database for new year and clear out the previous data.
     * +!+ WARNING +!+ THIS FUNCTION DOESN'T CREATE ANY BACKUP. +!+ WARNING +!+
     */
    @Override
    public void newYear() {
        attendanceRepository.deleteAll();
        timeTableRepository.deleteAll();
        reportRepository.deleteAll();
        examRepository.deleteAll();
        remarkRepository.deleteAll();
        for(Classroom classroom: classroomRepository.findAll()) {
            int new_year = classroom.getYear() + 1;
            classroom.setYear(new_year);
            classroomRepository.save(classroom);
        }
    }

    /**
     * Creates an archive file, that contains all student reports.
     *
     */
    @Override
    public String createArchive() {
        for(Student student: studentRepository.findAll()) {
            saveReportsByStudent(student.getId(), new Archive(
                    student.getStudent().getUsername(),
                    student.getStudent().getFullName(),
                    student.getDateOfBirth()
            ));
        }
        return "Archived";
    }

    /**
     * Returns a List of Archive Report.
     *
     * @return a list of archive report.
     */
    @Override
    public List<Archive> getArchive() {
        return archiveRepository.findAll();
    }

    /**
     * Returns an Archive  by student id.
     *
     * @param id Id of the archive;
     * @return a list of archive report.
     */
    @Override
    public Archive getArchiveById(Long id) {
        return archiveRepository.getOne(id);
    }

    /**
     * If, the class finished the school, this function delete the class
     * and also all student from the class.
     *
     * @param classroom_id Id of the classroom.
     */
    @Override
    public void finished(Long classroom_id) {
        List<Student> students = getStudentsFromClassroom(classroom_id);
        for(Student student: students) {
            studentRepository.delete(student);
            userRepository.delete(student.getStudent());
            deleteClassroomById(classroom_id);
        }
        classroomRepository.delete(classroomRepository.getOne(classroom_id));
    }

    /**
     * This function finds all report by student and returns with a list of
     * ArchiveReport. !IMPORTANT! The collected reports are from 2nd Semester.
     *
     * @param student_id Id of the student.
     * @return a List of ArchiveReport.
     */
    private List<ArchiveReport> saveReportsByStudent(Long student_id, Archive archive) {
        List<ArchiveReport> result = new ArrayList<>();
        for(Report report: reportRepository.findAll()) {
            if(report.getStudent().getId().equals(student_id) && report.getSemester() == 2) {
                ArchiveReport archiveReport = new ArchiveReport(
                        report.getCourse().getTitle(),
                        report.getYear(),
                        report.getMark(),
                        archiveRepository.save(archive)
                );
                result.add(archiveReport);
                archiveReportRepository.save(archiveReport);
            }
        }
        return result;
    }

    /**
     * Returns a List of Students, who are in the class.
     *
     * @param id Id of the classroom.
     * @return List of students.
     */
    private List<Student> getStudentsFromClassroom(Long id) {
        return studentRepository
                .findAll()
                .stream()
                .filter(student -> student.getClassroom().getId().equals(id))
                .collect(Collectors.toList());
    }

    /**
     * Deletes a classroom from database by id.
     *
     * @param id Id of the classroom.
     */
    private void deleteClassroomById(Long id) {
        Classroom classroom = classroomRepository.getOne(id);
        List<Authority> authorities = authService.findByName("ROLE_TEACHER");
        classroom.getHeadTeacher().getTeacher().setAuthorities(authorities);
        classroomRepository.delete(classroomRepository.getOne(id));
    }

}
