import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user.service';
import { AuthService } from 'src/app/service/auth.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router, private userService: UserService,
    private authService: AuthService) { }

  user: any;
  role: string;
  isDataAvailable:boolean = false;

  ngOnInit() {
    this.isDataAvailable = true
  }

  home() {
    this.router.navigate(["/home"]);
  }

  logout() {
    this.authService.logout().subscribe(res => {
      this.router.navigate(["/login"]);
    });
  }

  login() {
    this.router.navigate(["/login"]);
  }

  hasSignedIn() {
    return !!this.userService.currentUser;
  }

}
