import { Component, OnInit, OnDestroy } from '@angular/core';
import { Teacher } from 'src/app/model/teacher';
import { UserService } from 'src/app/service/user.service';
import { ActivatedRoute } from '@angular/router';
import { TeacherService } from 'src/app/service/teacher.service';

@Component({
  selector: 'app-teacher-details',
  templateUrl: './teacher-details.component.html',
  styleUrls: ['./teacher-details.component.scss']
})
export class TeacherDetailsComponent implements OnInit {

  user: any = {};
  id: number = 0;
  teacher = new Teacher();
  isDataAvailable:boolean = false;

  constructor(private userService: UserService, private route: ActivatedRoute, 
    private teacherService: TeacherService) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.user = data;
    }).then(() =>  this.teacherService.findById(this.id).subscribe(data => this.teacher = data))
    .then(() => this.isDataAvailable = true);
  }

  userRole(): string {
    return this.user.authorities[0].authority + '';
  }

}
