import { Component, OnInit } from '@angular/core';
import { ClassroomService } from 'src/app/service/classroom.service';
import { Observable } from 'rxjs';
import { Teacher } from 'src/app/model/teacher';
import { UserService } from 'src/app/service/user.service';
import { TeacherService } from 'src/app/service/teacher.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Classroom } from 'src/app/model/classroom';
import { ClassroomResponseDTO } from 'src/app/dto/response/classroomResponseDTO';

@Component({
  selector: 'app-classroom-update',
  templateUrl: './classroom-update.component.html',
  styleUrls: ['./classroom-update.component.scss']
})
export class ClassroomUpdateComponent implements OnInit {

  currentUser: any = {};
  isDataAvailable: boolean = false;
  id: number;
  teachers: Observable<Teacher[]>;
  classroom = new Classroom();
  response = new ClassroomResponseDTO();
  selectedOption: any = {};

  constructor(private userService: UserService, private teacherService: TeacherService, 
    private router: Router, private route: ActivatedRoute, private classroomService: ClassroomService) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data;
      this.classroomService.findById(this.id).subscribe(data =>  {
        this.classroom = data;
        this.teacherService.findAll().subscribe(data => { 
          this.teachers = data;
          this.isDataAvailable = true;
        });
      });
    });
  }

  isDataChanged() {
    if(!this.response.end_year 
      || !this.response.headTeacher_id
      || !this.response.letter
      || !this.response.start_year
      || this.response.year) return true;
    return false;
  }

  onSubmit() {
    if(this.isDataChanged) {
      this.response.headTeacher_id = Number(this.selectedOption.id);
      if(!this.response.headTeacher_id) this.response.headTeacher_id = this.classroom.headTeacher.id;
      if(!this.response.end_year) this.response.end_year = this.classroom.end_year;
      if(!this.response.letter) this.response.letter = this.classroom.letter;
      if(!this.response.start_year) this.response.start_year = this.classroom.start_year;
      if(!this.response.year) this.response.year = this.classroom.year;
      this.classroomService.update(this.id, this.response).subscribe(() => this.goBack());
    } else {
      this.goBack();
    }
  }

  goBack() {
    this.router.navigate(['/classroom/all']);
  }

  isHeadTeacher() {
    return this.currentUser.authorities[0].authority + '' == 'ROLE_HEADTEACHER';
  }

  userRole(): string {
    return this.currentUser.authorities[0].authority + '';
  }
}
