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
        return this.apiService.get(this.configService.getAllAttendanceByStudentUrl + '/' + student_id);
    }

    create(attendances: AttendanceResponseDTO[]) {
        return this.apiService.post(this.configService.getCreateAttendanceUrl, attendances);
    }

    delete(id: number) {
        return this.apiService.delete(this.configService.getDeleteAttendaceUrl + '/' + id, id);
    }

    verify(id: number) {
        return this.apiService.put(this.configService.getVerifyAttendanceUrl + '/' + id, id);
    }

    nonVerifyByStudent(student_id: number) {
        return this.apiService.get(this.configService.getNonVerifyAttendanceUrl + '/' + student_id);
    }

    makeAttendanceFormToClassroom(classroom_id: number) {
        return this.apiService.get(this.configService.getMakeAttendanceFormToClassroomUrl + '/' + classroom_id);
    }

}