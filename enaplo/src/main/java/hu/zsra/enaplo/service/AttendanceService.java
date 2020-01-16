package hu.zsra.enaplo.service;

import hu.zsra.enaplo.dto.AttendanceDTO;
import hu.zsra.enaplo.model.Attendance;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceService {

    List<AttendanceDTO> getForm(Long classroom_id);
    List<Attendance> create(List<AttendanceDTO> attendanceDTOS, int lesson, LocalDate dateOfMiss);
    void verify(Long id);
    List<Attendance> nonVerifyByStudent(Long student_id);
    List<Attendance> getAllByStudent(Long student_id);
    void delete(Long id);
}
