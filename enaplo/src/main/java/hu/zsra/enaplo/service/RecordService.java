package hu.zsra.enaplo.service;

import hu.zsra.enaplo.dto.SummaryDTO;
import hu.zsra.enaplo.model.Course;
import hu.zsra.enaplo.model.exam.Exam;
import hu.zsra.enaplo.model.user.Student;
import hu.zsra.enaplo.repository.CourseRepository;
import hu.zsra.enaplo.repository.user.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;


    public List<SummaryDTO> getSummary(String username) {
        final Student student = studentRepository.findByUsername(username);
        List<SummaryDTO> summaryDTOList = new ArrayList<>();

        for(Course course : courseRepository.findAll()) {
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
