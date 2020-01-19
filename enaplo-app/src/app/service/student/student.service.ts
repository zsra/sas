import {Injectable} from '@angular/core';
import {ApiService} from '../api.service';
import {ConfigService} from '../config.service';
import {map} from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class StudentService {

    constructor(private apiService: ApiService, private configService: ConfigService) {

    }

    findById(id: number) {
        return this.apiService.get(this.configService.getStudentUrl + '/' + id);
    }

    findByUserId(user_id : number) {
        return this.apiService.get(this.configService.getStudentByUserIdUrl + '/' + user_id);
    }

    create() {

    }

    update() {

    }

    delete() {

    }

    summary(id : number) {
        return this.apiService.get(this.configService.getSummaryStudentUrl, id);
    }

}