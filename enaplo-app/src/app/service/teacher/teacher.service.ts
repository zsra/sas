import { Injectable } from '@angular/core';
import { ApiService } from '../api.service';
import { ConfigService } from '../config.service';

@Injectable({
    providedIn: 'root'
})
export class TeacherService {
    
    constructor(private apiService: ApiService, private configService: ConfigService) {
    }

    findById(id: number) {
        return this.apiService.get(this.configService.getFindTeacherById + '/' + id);
    }

    findByUserId(user_id : number) {
        return this.apiService.get(this.configService.getFindTeacherByUserId + '/' + user_id);
    }
}