package hu.zsra.enaplo.service;

import hu.zsra.enaplo.model.TimeTableEntity;

public interface TimeTableService {

    TimeTableEntity create(TimeTableEntity timeTableEntity);
    TimeTableEntity update(Long id, TimeTableEntity timeTableEntity);
    void delete(Long id);
    TimeTableEntity[][] getTimeTableByStudent(Long id);
    TimeTableEntity[][] getTimeTableByTeacher(Long id);
}
