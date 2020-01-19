import { Component, OnInit, OnDestroy } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/service/user.service';
import { Router } from '@angular/router';
import { StudentService } from 'src/app/service/student/student.service';
import { TeacherService } from 'src/app/service/teacher/teacher.service';
import { Student } from 'src/app/model/student';
import { Teacher } from 'src/app/model/teacher';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  searchText;
  users: Observable<User[]>;
  isDataAvailable:boolean = false;
  user: any;
  constructor(private userService: UserService, private router: Router,
    private studentService: StudentService, private teacherService: TeacherService) { }

  ngOnInit() {
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.user = data;
      this.users = this.userService.getAll();
    }).then(() => this.isDataAvailable = true);
  }

  userRole(): string {
    return this.user.authorities[0].authority + '';
  }

  getDetails(user_id: number) {
    this.userService.getById(user_id).subscribe(data => {
      if(data.authorities[0].authority + '' === 'ROLE_STUDENT') {
        this.studentService.findByUserId(user_id).subscribe(data => this.router.navigate(['student/details', data.id]));
      } else if(data.authorities[0].authority + '' === 'ROLE_TEACHER' 
                  || data.authorities[0].authority + '' === 'ROLE_HEADTEACHER') {
        this.teacherService.findByUserId(user_id).subscribe(data => this.router.navigate(['teacher/details', data.id])); 
      }
    });
  }

  deleteUser(user_id: number) {

  }
}
