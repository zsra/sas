import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {ConfigService} from './config.service';
import {map} from 'rxjs/operators';
import { User } from '../model/user';
import { StudentResponseDTO } from '../dto/response/studentResponseDTO';
import { TeacherResponseDTO } from '../dto/response/teacherResponseDTO';

@Injectable({
    providedIn: 'root'
})
export class AdminService {

    constructor(private apiService: ApiService, private configService: ConfigService) {

    }

    createUser(user: User) {
        return this.apiService.post(this.configService.getCreateUrl, user);
    }

    createStudent(student: StudentResponseDTO) {
        return this.apiService.post(this.configService.getCreateStudentUrl, student);
    }

    createTeacher(teacher: TeacherResponseDTO) {
        return this.apiService.post(this.configService.getCreateTeacherUrl, teacher);
    }
  
    createCourse() {
    }

    createTimeTable() {
        
    }
  
    createClassroom() {
  
    }
  
    updateClassroom() {
  
    }
  
    deleteUser() {
  
    }
  
    deleteCourse() {
  
    }
  
    deleteClassroom() {
  
    }
  
    getAllUser() {
  
    } 
}