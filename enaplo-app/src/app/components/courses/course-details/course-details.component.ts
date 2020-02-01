import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/model/course';
import { UserService } from 'src/app/service/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CourseService } from 'src/app/service/course.service';

@Component({
  selector: 'app-course-details',
  templateUrl: './course-details.component.html',
  styleUrls: ['./course-details.component.scss']
})
export class CourseDetailsComponent implements OnInit {

  currentUser: any = {};
  id: number = 0;
  course = new Course();
  isDataAvailable:boolean = false;

  constructor(private userService: UserService, private route: ActivatedRoute, 
    private courseService: CourseService, private router: Router) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data;
      this.courseService.findById(this.id).subscribe(data => { 
        this.course = data;
        this.isDataAvailable = true;
      });
    });
  }

  goBack() {
    this.router.navigate(['course/all']);
  }

  hasSignedId() {
    return !!this.userService.currentUser;
  }
}
