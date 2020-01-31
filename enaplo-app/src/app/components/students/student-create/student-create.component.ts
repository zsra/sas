import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';
import { Router } from '@angular/router';
import { StudentService } from 'src/app/service/student.service';
import { StudentResponseDTO } from 'src/app/dto/response/studentResponseDTO';
import { Observable } from 'rxjs';
import { Classroom } from 'src/app/model/classroom';
import { ClassroomService } from 'src/app/service/classroom.service';
import { UserResponseDTO } from 'src/app/dto/response/userResponseDTO';

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.scss']
})
export class StudentCreateComponent implements OnInit {

  user = new UserResponseDTO();
  student = new StudentResponseDTO();
  currentUser: any = {};
  userSubmitted: boolean = false;
  isDataAvailable: boolean  = false;
  classrooms: Observable<Classroom[]>;
  selectedOption: any = {};

  constructor(private userService: UserService, private router: Router,
    private studentService: StudentService, private classroomService: ClassroomService) { }

  ngOnInit() {
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data;
      this.classroomService.findAll().subscribe(data => {
        this.classrooms = data;
        this.isDataAvailable = true;
      });
    });
  }

  onUserSubmit() {
    this.user.role = 'ROLE_STUDENT';
    this.student.username = this.user.username;  
    this.userService.create(this.user).subscribe();
    this.userSubmitted = true;
  }

  onStudentSubmit() {
    this.student.classroom_id = Number(this.selectedOption.id);
    this.studentService.create(this.student).subscribe();
    this.router.navigate(['/user/all']);
  }

  userRole(): string {
    return this.currentUser.authorities[0].authority + '';
  }

}
