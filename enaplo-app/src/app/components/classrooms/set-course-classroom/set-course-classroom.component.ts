import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Course } from 'src/app/model/course';
import { UserService } from 'src/app/service/user.service';
import { CourseService } from 'src/app/service/course.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ClassroomService } from 'src/app/service/classroom.service';

@Component({
  selector: 'app-set-course-classroom',
  templateUrl: './set-course-classroom.component.html',
  styleUrls: ['./set-course-classroom.component.scss']
})
export class SetCourseClassroomComponent implements OnInit {

  currentUser: any = {};
  selectedOption: any = {};
  classroom_id: number;
  isDataAvailable: boolean = false;
  courses: Observable<Course[]>;

  constructor(private userService: UserService, private courseService: CourseService, private route: ActivatedRoute,
    private router: Router, private classroomService: ClassroomService) { }

  ngOnInit() {
    this.classroom_id = this.route.snapshot.params['id'];
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data;
      this.courseService.findAll().subscribe(data => {
        this.courses = data;
        this.isDataAvailable = true;
      });
    });
  }

  onSubmit() {
    this.classroomService.setCourse(this.classroom_id, this.selectedOption.id).subscribe();
    this.goBack();
  }

  goBack() {
    this.router.navigate(['classroom/all']);
  }

  userRole(): string {
    return this.currentUser.authorities[0].authority + '';
  }
}
