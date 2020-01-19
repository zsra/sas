import { Component, OnInit, OnDestroy } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';
import { UserService } from 'src/app/service/user.service';
import { AdminService } from 'src/app/service/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.scss']
})
export class AdminPanelComponent implements OnInit, OnDestroy {

  constructor(private authService: AuthService, private userService: UserService,
    private adminService: AdminService, private router: Router) { }

  ngOnInit() {
  }

  ngOnDestroy() {
  }

  createUser() {

  }

  createCourse() {

  }

  createClassroom() {

  }

  getAllUser() {

  }

  getAllClassroom() {

  }
}
