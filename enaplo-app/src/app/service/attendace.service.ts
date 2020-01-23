import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {ConfigService} from './config.service';
import {map} from 'rxjs/operators';
import { ReportResponseDTO } from 'src/app/dto/response/reportResponseDTO';
import { AttendanceResponseDTO } from '../dto/response/attendanceResponseDTO';

@Injectable({
    providedIn: 'root'
})
export class AttendanceService {

    constructor(private apiService: ApiService, private configService: ConfigService) {

    }

    getAllByStudent(student_id: number) {
        this.apiService.get(this.configService.getAllAttendanceByStudentUrl + '/' + student_id);
    }

    create(attendances: AttendanceResponseDTO) {
        this.apiService.post(this.configService.getCreateAttendanceUrl, attendances);
    }

    delete(id: number) {
        this.apiService.delete(this.configService.getDeleteAttendaceUrl + '/' + id, id);
    }

    verify(id: number) {
        this.apiService.put(this.configService.getVerifyAttendanceUrl + '/' + id, id);
    }

    nonVerifyByStudent(student_id: number) {
        this.apiService.get(this.configService.getNonVerifyAttendanceUrl);
    }

    makeAttendanceFormToClassroom(classroom_id: number) {
        this.apiService.get(this.configService.getMakeAttendanceFormToClassroomUrl + '/' + classroom_id);
    }
}