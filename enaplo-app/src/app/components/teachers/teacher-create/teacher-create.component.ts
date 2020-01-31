import { Component, OnInit } from '@angular/core';
import { UserResponseDTO } from 'src/app/dto/response/userResponseDTO';
import { TeacherResponseDTO } from 'src/app/dto/response/teacherResponseDTO';
import { Observable } from 'rxjs';
import { UserService } from 'src/app/service/user.service';
import { Router } from '@angular/router';
import { TeacherService } from 'src/app/service/teacher.service';

@Component({
  selector: 'app-teacher-create',
  templateUrl: './teacher-create.component.html',
  styleUrls: ['./teacher-create.component.scss']
})
export class TeacherCreateComponent implements OnInit {

  user = new UserResponseDTO();
  teacher = new TeacherResponseDTO();
  currentUser: any = {};
  userSubmitted: boolean = false;
  isDataAvailable: boolean  = false;
  selectedOption: any = {};

  constructor(private userService: UserService, private router: Router,
    private teacherService: TeacherService) { }

  ngOnInit() {
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data;
      this.isDataAvailable = true;
    });
  }

  onUserSubmit() {
    this.user.role = 'ROLE_STUDENT';
    this.teacher.username = this.user.username;  
    this.userService.create(this.user).subscribe();
    this.userSubmitted = true;
  }

  onTeacherSubmit() {
    this.teacherService.create(this.teacher).subscribe();
    this.goBack();
    this.userSubmitted = false;
    this.user = new UserResponseDTO();
    this.teacher = new TeacherResponseDTO();
  }

  goBack() {
    this.router.navigate(['/user/all']);
  }

  userRole(): string {
    return this.currentUser.authorities[0].authority + '';
  }
}
