import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {ConfigService} from './config.service';
import {map} from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class AdminService {

    constructor(private apiService: ApiService, private configService: ConfigService) {

    }

    createUser() {

    }
  
    createCourse() {
  
    }
  
    createClassroom() {
  
    }
  
    updateClassroom() {
  
    }
  
    deleteUser() {
  
    }
  
    deleteCourse() {
  
    }
  
    deletClassroom() {
  
    }
  
    getAllUser() {
  
    } 
}