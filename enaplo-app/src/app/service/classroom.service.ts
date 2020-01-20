import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { ConfigService } from './config.service';
import { Classroom } from '../model/classroom';

@Injectable({
    providedIn: 'root'
})
export class ClassroomService {

    constructor(private apiService: ApiService, private configService: ConfigService) {

    }

    getAll() {
        return this.apiService.get(this.configService.getAllClassroomUrl);
    }

    create(classroom: Classroom) {
        return this.apiService.post(this.configService.getCreateClassroomUrl, classroom);
    }

    update(classroom: Classroom) {
        return this.apiService.put(this.configService.getUpdateClassroomUrl + '/' + classroom.id, classroom);
    }

    delete(classroom_id: number) {
        return this.apiService.delete(this.configService.getDeleteClassroomUrl + '/' + classroom_id, classroom_id);
    }  

    getStudentsFromClassroom() {

    }

    setCourse() {

    }

    getById() {

    }
}