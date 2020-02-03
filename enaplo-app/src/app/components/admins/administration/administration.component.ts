import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';
import { AdminService } from 'src/app/service/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-administration',
  templateUrl: './administration.component.html',
  styleUrls: ['./administration.component.scss']
})
export class AdministrationComponent implements OnInit {

  currentUser: any = {};
  isDataAvailable:boolean = false;

  constructor(private userService: UserService, private adminService: AdminService) { }

  ngOnInit() {
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data;
      this.isDataAvailable = true;
    });
  }

  create() {
    this.adminService.createArchive().subscribe(() => {});
  }

  newYear() {
    this.adminService.newYear().subscribe(() => {});
  }

  finished() {
    this.adminService.finished().subscribe(() => {});
  }
}
