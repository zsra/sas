package hu.zsra.enaplo.service;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.Attendance;
import hu.zsra.enaplo.model.user.Parent;
import hu.zsra.enaplo.model.user.Student;
import hu.zsra.enaplo.repository.AttendanceRepository;
import hu.zsra.enaplo.repository.user.ParentRepository;
import hu.zsra.enaplo.repository.user.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private StudentRepository studentRepository;

    public Attendance create(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public Attendance verify(Long id) throws ResourceNotFoundException {
        Attendance attendance = attendanceRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found"));

        attendance.setVerified(true);

        return attendanceRepository.save(attendance);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        attendanceRepository.delete(attendanceRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found!"))
        );
    }

    public Set<Attendance> getAttendances(String username) throws ResourceNotFoundException {
        Student students = studentRepository
                .findAll()
                .stream()
                .filter(student -> student.getUsername().equals(username))
                .findAny().orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        return students.getAttendances();
    }

    public Set<Attendance> getNonVerifiedAttendances(String username) throws ResourceNotFoundException {
        return getAttendances(username).stream()
                .filter(attendance -> !attendance.isVerified())
                .collect(Collectors.toSet());
    }
}
