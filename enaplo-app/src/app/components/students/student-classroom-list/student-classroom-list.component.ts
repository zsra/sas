import { Component, OnInit } from '@angular/core';
import { ClassroomService } from 'src/app/service/classroom.service';
import { Observable } from 'rxjs';
import { UserService } from 'src/app/service/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Student } from 'src/app/model/student';
import { StudentService } from 'src/app/service/student.service';

@Component({
  selector: 'app-student-classroom-list',
  templateUrl: './student-classroom-list.component.html',
  styleUrls: ['./student-classroom-list.component.scss']
})
export class StudentClassroomListComponent implements OnInit {

  classroom_id: number;
  searchText;
  students: Observable<Student[]>;
  isDataAvailable:boolean = false;
  user: any;

  constructor(private userService: UserService, private router: Router,
    private classroomService: ClassroomService, private route: ActivatedRoute, 
    private studentService: StudentService) { }

  ngOnInit() {
    this.classroom_id = this.route.snapshot.params['id'];
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.user = data;
      this.classroomService.getStudentsFromClassroom(this.classroom_id).subscribe(data => this.students = data);
    }).then(() => this.isDataAvailable = true);
  }

  userRole(): string {
    return this.user.authorities[0].authority + '';
  }

  details(user_id: number) {
    this.userService.getById(user_id).subscribe(data => {
      this.studentService.findByUserId(user_id).subscribe(data => this.router.navigate(['student/details', data.id]));
    });
  }

  isHeadTeacher() {
    return this.user.authorities[0].authority + '' == 'ROLE_HEADTEACHER';
  }

  summary(user_id: number) {

  }

  reports(user_id: number) {

  }

}
