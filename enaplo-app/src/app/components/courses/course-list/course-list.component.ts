import { Component, OnInit } from '@angular/core';
import { CourseService } from 'src/app/service/course.service';
import { Observable } from 'rxjs';
import { UserService } from 'src/app/service/user.service';
import { Router } from '@angular/router';
import { Course } from 'src/app/model/course';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.scss']
})
export class CourseListComponent implements OnInit {

  searchText;
  courses: Observable<Course[]>;
  isDataAvailable:boolean = false;
  user: any;

  constructor(private userService: UserService, private router: Router,
    private courseService: CourseService) { }

  ngOnInit() {
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.user = data;
      this.courseService.findAll().subscribe(data =>
        this.courses = data);
    }).then(() => this.isDataAvailable = true);
  }

  hasSignedIn() {
    return !!this.userService.currentUser;
  }

  details(course_id: number) {
    this.courseService.findById(course_id).subscribe(
      data => this.router.navigate(['/course/details/', data.id])
    );
  }

  update(course_id: number) {
    this.courseService.findById(course_id).subscribe(
      data => this.router.navigate(['/course/update', data.id])
    );
  }

  delete(course_id: number) {

  }
}
