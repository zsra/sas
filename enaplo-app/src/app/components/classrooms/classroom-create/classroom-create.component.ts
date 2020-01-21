import { Component, OnInit } from '@angular/core';
import { Classroom } from 'src/app/model/classroom';
import { Observable } from 'rxjs';
import { Teacher } from 'src/app/model/teacher';
import { UserService } from 'src/app/service/user.service';
import { Router } from '@angular/router';
import { TeacherService } from 'src/app/service/teacher/teacher.service';
import { ClassroomService } from 'src/app/service/classroom.service';

@Component({
  selector: 'app-classroom-create',
  templateUrl: './classroom-create.component.html',
  styleUrls: ['./classroom-create.component.scss']
})
export class ClassroomCreateComponent implements OnInit {

  classroom = new Classroom();
  admin: any = {};
  userSubmitted: boolean = false;
  isDataLoaded: boolean  = false;
  teachers: Observable<Teacher[]>;
  selectedOption: any = {};

  constructor(private userService: UserService, private router: Router,
    private teacherService: TeacherService, private classroomService: ClassroomService) { }

  ngOnInit() {
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.admin = data;
    }).then(() => {
      this.teacherService.findAll().subscribe(data =>
        this.teachers = data);
    })
    .then(() => this.isDataLoaded = true);
  }

  onSubmit() {
    
  }

  goBack() {
    this.router.navigate(['/classroom/all']);
  }

  userRole(): string {
    return this.admin.authorities[0].authority + '';
  }

}
