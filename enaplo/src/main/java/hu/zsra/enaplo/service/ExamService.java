package hu.zsra.enaplo.service;

import hu.zsra.enaplo.model.Exam;

public interface ExamService {

    Exam create(Exam exam);
    Exam update(Long id, Exam exam);
    void delete(Long id);
}
