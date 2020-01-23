import { Injectable } from '@angular/core';

import { ApiService } from './api.service';

import { ConfigService } from './config.service';
import { TimeTableEntityResponseDTO } from '../dto/response/timeTableEntityResponseDTO';

@Injectable({
    providedIn: 'root'
})
export class TimeTableService {
    
    constructor(private apiService: ApiService, private configService: ConfigService) {
        
    }

    getTimeTableByStudent(id: number) {
        return this.apiService.get(this.configService.getGetTimeTableByStudentUrl + '/' + id);
    }

    getTimeTableByTeacher(id: number) {
        return this.apiService.get(this.configService.getGetTimeTableByTeacherUrl + '/' + id);
    }

    create(timeTableEntity: TimeTableEntityResponseDTO) {
        return this.apiService.post(this.configService.getCreateTimeTableUrl, timeTableEntity);
    }

    update(id: number, timeTableEntity: TimeTableEntityResponseDTO) {
        return this.apiService.put(this.configService.getUpdateTimeTableUrl + '/' + id, timeTableEntity);
    }

    delete(id: number) {
        return this.apiService.delete(this.configService.getDeleteTimeTableUrl + '/' + id, id);
    }
}