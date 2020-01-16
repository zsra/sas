package hu.zsra.enaplo.service.impl;

import hu.zsra.enaplo.dto.AttendanceDTO;
import hu.zsra.enaplo.model.Attendance;
import hu.zsra.enaplo.model.user.group.Student;
import hu.zsra.enaplo.repository.AttendanceRepository;
import hu.zsra.enaplo.repository.user.StudentRepository;
import hu.zsra.enaplo.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<AttendanceDTO> getForm(Long classroom_id) {
        List<AttendanceDTO> result = new ArrayList<>();
        for (Student student : getAllStudentByClassroom(classroom_id)) {
            result.add(new AttendanceDTO(student));
        }
        return result;
    }

    @Override
    public List<Attendance> create(List<AttendanceDTO> attendanceDTOS, int lesson, LocalDate dateOfMiss) {
        List<Attendance> attendances = new ArrayList<>();
        for(AttendanceDTO attendanceDTO : attendanceDTOS) {
            attendances.add(new Attendance(attendanceDTO.getStudent(), lesson, dateOfMiss));
        }
        return attendanceRepository.saveAll(attendances);
    }

    @Override
    public void verify(Long id) {
        Attendance attendance = attendanceRepository.getOne(id);
        attendance.setVerified(true);
        attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> nonVerifyByStudent(Long student_id) {
        return attendanceRepository
                .findAll()
                .stream()
                .filter(attendance -> attendance.getStudent().getId().equals(student_id))
                .collect(Collectors.toList());
    }

    @Override
    public List<Attendance> getAllByStudent(Long student_id) {
        return attendanceRepository
                .findAll()
                .stream()
                .filter(attendance -> attendance.getStudent().getId().equals(student_id) && !attendance.isVerified())
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Attendance attendance = attendanceRepository.getOne(id);
        attendanceRepository.delete(attendance);
    }

    private List<Student> getAllStudentByClassroom(Long classroom_id) {
        return studentRepository
                .findAll()
                .stream()
                .filter(student -> student.getClassroom().getId().equals(classroom_id))
                .collect(Collectors.toList());
    }
}
