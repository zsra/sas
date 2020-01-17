import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';
import { UserService } from 'src/app/service/user.service';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.scss']
})
export class AdminPanelComponent implements OnInit {

  constructor(private authService: AuthService, private userService: UserService,
    private adminService: AdminService) { }

  ngOnInit() {
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
