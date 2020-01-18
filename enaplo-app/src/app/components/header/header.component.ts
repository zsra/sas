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

  roles: [
    'ROLE_STUDENT',
    'ROLE_TEACHER',
    'ROLE_ADMIN',
    'ROLE_HEADTEACHER'
  ];

  ngOnInit() {
    
  }

  logout() {
    this.authService.logout().subscribe(res => {
      this.router.navigate(["/login"]);
    });
  }

  userRole(): string {
    if(!!this.userService.currentUser) {
      this.userService.getMyInfo()
        .subscribe(data =>  this.role = data.authorities[0].authority + '');
        console.log(this.role)
          return this.role;
    } else {
      return '';
    }
    
  }

  hasSignedIn() {
    return !!this.userService.currentUser;
  }

}
