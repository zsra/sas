import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.scss']
})
export class AdminPanelComponent implements OnInit {

  currentUser: any = {};
  isDataAvailable: boolean = false;

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data; 
      this.isDataAvailable = true;
    });
  }

  createStudent() {
    this.router.navigate(['/student/create']);
  }

  createTeacher() {
    this.router.navigate(['/teacher/create']);
  }

  getAllUser() {
    this.router.navigate(['/user/all']);
  }

  getAllClassroom() {
    this.router.navigate(['/classroom/all']);
  }

  getAllCourse() {
    this.router.navigate(['/course/all']);
  }

  update() {
    this.userService.getById(this.currentUser.id).subscribe(data =>
      this.router.navigate(['user/update', data.id]));
  }

  admin() {
    this.router.navigate(['admin/control']);
  }

  archives() {
    this.router.navigate(['archive/all']);
  }
}
