import { Component, OnInit, OnDestroy } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/service/user.service';
import { ConfigService } from 'src/app/service/config.service';
import { Router } from '@angular/router';
import { StudentService } from 'src/app/service/student/student.service';
import { TeacherService } from 'src/app/service/teacher/teacher.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit, OnDestroy {

  admin: any;
  users: Observable<User[]>;

  constructor(private userService: UserService, private router: Router,
    private studentService: StudentService, private teacherService: TeacherService) { }

  ngOnInit() {
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.admin = data;
    });
    this.reloadData();
  }

  userRole(): string {
    return this.admin.authorities[0].authority + '';
  }

  ngOnDestroy() {
    this.admin = null;
  }

  reloadData() {
    this.users = this.userService.getAll();
  }

  getDetails(user_id: number) {
    var student = this.studentService.findByUserId(user_id);
    console.log(student.toPromise().then(data => console.log(data)));
  }

  deleteUser(user_id: number) {

  }
}
