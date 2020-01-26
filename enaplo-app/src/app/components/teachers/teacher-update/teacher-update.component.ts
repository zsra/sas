import { Component, OnInit } from '@angular/core';
import { Teacher } from 'src/app/model/teacher';
import { TeacherResponseDTO } from 'src/app/dto/response/teacherResponseDTO';
import { UserService } from 'src/app/service/user.service';
import { ConfigService } from 'src/app/service/config.service';
import { TeacherService } from 'src/app/service/teacher.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-teacher-update',
  templateUrl: './teacher-update.component.html',
  styleUrls: ['./teacher-update.component.scss']
})
export class TeacherUpdateComponent implements OnInit {

  currentUser: any = {}
  id: number;
  teacher = new Teacher();
  response = new TeacherResponseDTO();
  isDataAvailable: boolean  = false;

  constructor(private userService: UserService, private teacherService: TeacherService, 
    private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data; 
      this.teacherService.findById(this.id).subscribe(data => this.teacher = data);
    }).then(() => this.isDataAvailable = true);
  }

  isDataChanged() {
    if(!this.response.email || !this.response.phone) return true;
    return false;
  }

  submit() {
    if(this.isDataChanged) {
      if(!this.response.email) this.response.email = this.teacher.email;
      if(!this.response.phone) this.response.phone = this.teacher.phone;
      this.teacherService.update(this.id, this.response).subscribe();
    }
    if(this.currentUser.authorities[0].authority + '' === 'ROLE_ADMIN') {
      this.router.navigate(['/user/all']);
    } else {
      this.router.navigate(['/home']);
    }
  }

  userUpdate() {
    this.userService.getById(this.teacher.teacher.id).subscribe(data =>
      this.router.navigate(['user/update', data.id]))
  }

  userRole(): string {
    return this.currentUser.authorities[0].authority + '';
  }
}
