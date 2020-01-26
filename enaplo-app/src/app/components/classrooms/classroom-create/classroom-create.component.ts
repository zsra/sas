import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Teacher } from 'src/app/model/teacher';
import { UserService } from 'src/app/service/user.service';
import { Router } from '@angular/router';
import { TeacherService } from 'src/app/service/teacher.service';
import { ClassroomService } from 'src/app/service/classroom.service';
import { ClassroomResponseDTO } from 'src/app/dto/response/classroomResponseDTO';

@Component({
  selector: 'app-classroom-create',
  templateUrl: './classroom-create.component.html',
  styleUrls: ['./classroom-create.component.scss']
})
export class ClassroomCreateComponent implements OnInit {

  classroom = new ClassroomResponseDTO();
  admin: any = {};
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
    this.classroom.headTeacher_id = Number(this.selectedOption.id);
    this.classroomService.create(this.classroom).subscribe(() => this.reset());
    this.refresh();
    this.goBack(); 
  }

  reset() {
    this.classroom = new ClassroomResponseDTO();
    this.isDataLoaded = false;
    this.selectedOption = {};
  }

  refresh(): void {
    window.location.reload();
  }

  goBack() {
    this.router.navigate(['/classroom/create']);
  }

  userRole(): string {
    return this.admin.authorities[0].authority + '';
  }

}
