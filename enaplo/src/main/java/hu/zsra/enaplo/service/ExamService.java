package hu.zsra.enaplo.service;

import hu.zsra.enaplo.exception.ResourceNotFoundException;
import hu.zsra.enaplo.model.exam.Exam;
import hu.zsra.enaplo.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    public Exam create(Exam exam) {
        return examRepository.save(exam);
    }

    public Exam update(Long id, Exam exam) throws ResourceNotFoundException {
        Exam oldExam = examRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exam not found"));

        oldExam.setMark(exam.getMark());
        oldExam.setExamType(exam.getExamType());

        return examRepository.save(oldExam);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        Exam exam = examRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exam not found"));
        examRepository.delete(exam);
    }
}
