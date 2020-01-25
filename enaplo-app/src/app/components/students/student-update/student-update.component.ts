import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/model/student';
import { StudentResponseDTO } from 'src/app/dto/response/studentResponseDTO';
import { UserService } from 'src/app/service/user.service';
import { ConfigService } from 'src/app/service/config.service';
import { StudentService } from 'src/app/service/student.service';
import { Observable } from 'rxjs';
import { Classroom } from 'src/app/model/classroom';
import { Router, ActivatedRoute } from '@angular/router';
import { ClassroomService } from 'src/app/service/classroom.service';

@Component({
  selector: 'app-student-update',
  templateUrl: './student-update.component.html',
  styleUrls: ['./student-update.component.scss']
})
export class StudentUpdateComponent implements OnInit {

  currentUser: any = {}
  id: number;
  student = new Student();
  response = new StudentResponseDTO();
  isDataAvailable: boolean  = false;
  classrooms: Observable<Classroom[]>;
  selectedOption: any = {};
  currentClassroom = new Classroom();

  constructor(private userService: UserService, private configService: ConfigService, 
    private studentService: StudentService, private router: Router,  private route: ActivatedRoute, 
    private classroomService: ClassroomService) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data;
      this.studentService.findById(this.id).subscribe(data => {
        this.student = data;
        this.classroomService.getById(data.classroom.id).subscribe(data => this.currentClassroom = data);
      });
    }).then(() =>
      this.classroomService.getAll().subscribe(data => this.classrooms = data)
    ).then(() => {
      this.response.address = this.student.address;
      this.response.parent1Name = this.student.parent1Name;
      this.response.parent2Name = this.student.parent2Name;
      this.response.parent1Phone = this.student.parent1Phone;
      this.response.parent2Phone = this.student.parent2Phone;
      this.response.dateOfBirth = this.student.dateOfBirth;
      this.response.educationId = this.student.educationId;
      this.response.start_year = this.student.start_year;
      this.response.healthCareId = this.student.healthCareId;
      this.response.classroom_id = this.currentClassroom.id;
    }).then(() => this.isDataAvailable = true);
  }

  isDataChanged() {
    if(!this.response.address 
      || !this.response.parent1Name
      || !this.response.parent2Name
      || !this.response.parent1Phone
      || !this.response.parent2Phone
      || !this.response.dateOfBirth
      || !this.response.educationId
      || !this.response.start_year   
      || !this.response.healthCareId
      || !this.response.classroom_id) return true;
    return false;
  }

  submit() {
    if(this.isDataChanged) {
      if(!this.response.address) this.response.address = this.student.address;
      if(!this.response.parent1Name) this.response.parent1Name = this.student.parent1Name;
      if(!this.response.parent2Name) this.response.parent2Name = this.student.parent2Name;
      if(!this.response.parent1Phone) this.response.parent1Phone = this.student.parent1Phone;
      if(!this.response.parent2Phone) this.response.parent2Phone = this.student.parent2Phone;
      if(!this.response.dateOfBirth) this.response.dateOfBirth = this.student.dateOfBirth;
      if(!this.response.educationId) this.response.educationId = this.student.educationId;
      if(!this.response.start_year) this.response.start_year = this.student.start_year;
      if(!this.response.healthCareId) this.response.healthCareId = this.student.healthCareId;
      if(!this.response.classroom_id) this.response.classroom_id = this.currentClassroom.id;
      this.studentService.update(this.id, this.response).subscribe();
    }
    if(this.currentUser.authorities[0].authority + '' === 'ROLE_ADMIN') {
      this.router.navigate(['/user/all']);
    } else {
      this.router.navigate(['/home']);
    }
  }
  
  userUpdate() {
    this.userService.getById(this.student.student.id).subscribe(data =>
      this.router.navigate(['user/update', data.id]))
  }

  userRole(): string {
    return this.currentUser.authorities[0].authority + '';
  }

}
