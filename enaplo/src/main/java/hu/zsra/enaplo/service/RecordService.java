package hu.zsra.enaplo.service;

import hu.zsra.enaplo.dto.SummaryDTO;
import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.exam.Exam;
import hu.zsra.enaplo.model.user.Student;
import hu.zsra.enaplo.service.user.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecordService {

    @Autowired
    private StudentService studentService;

    public Set<SummaryDTO> getSummary(String username) {
        final Student student = studentService.getStudentByUsername(username);
        Set<SummaryDTO> summaryDTOList = new HashSet<>();

        for(Course course : student.getCourses()) {

            List<Exam> exams = student.getExams()
                    .stream()
                    .filter(exam -> exam.getCourse().getId().equals(course.getId()))
                    .collect(Collectors.toList());

            double average = exams.stream().mapToDouble(Exam::getMark).average().orElse(Double.NaN);

            summaryDTOList.add(new SummaryDTO(course.getTitle(),
                    exams.stream().mapToInt(Exam::getMark).toArray(), average));
        }
        return summaryDTOList;
    }
}
