package hu.zsra.enaplo.service.impl;

import hu.zsra.enaplo.model.Exam;
import hu.zsra.enaplo.repository.ExamRepository;
import hu.zsra.enaplo.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Override
    public Exam create(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Exam update(Long id, Exam exam) {
        Exam oldExam = examRepository.getOne(id);

        oldExam.setMark(exam.getMark());
        oldExam.setWrittenAt(exam.getWrittenAt());

        return examRepository.save(oldExam);
    }

    @Override
    public void delete(Long id) {
        examRepository.delete(examRepository.getOne(id));
    }
}
