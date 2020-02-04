import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';
import { CourseService } from 'src/app/service/course.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { TimeTableEntity } from 'src/app/model/timeTableEntity';
import { Course } from 'src/app/model/course';
import { TimeTableService } from 'src/app/service/timeTable.service';

@Component({
  selector: 'app-timetable-list',
  templateUrl: './timetable-list.component.html',
  styleUrls: ['./timetable-list.component.scss']
})
export class TimetableListComponent implements OnInit {

  course_id: number;
  currentUser: any = {};
  course = new Course();
  isDataAvailable: boolean = false;
  timeTable: Observable<TimeTableEntity[]>;

  constructor(private userService: UserService, private courseService: CourseService, 
    private router: Router, private route: ActivatedRoute, private timeTableService: TimeTableService) { }

  ngOnInit() {
    this.course_id = this.route.snapshot.params['id'];
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data;
      this.courseService.findById(this.course_id).subscribe(data => {
        this.course = data;
        this.timeTableService.getTimeTableEntitiesByCourse(this.course_id).subscribe(data => {
          this.timeTable = data;
          this.isDataAvailable = true;
        });
      });
    });
  }

  create() {
    this.courseService.findById(this.course_id).subscribe(data => 
      this.router.navigate(['/timetable/create', data.id])
    );
  }

  userRole(): string {
    return this.currentUser.authorities[0].authority + '';
  }

  update(entity_id: number) {
    this.router.navigate(['timetable/update', entity_id]);
  }

  delete(entity_id: number) {
    this.timeTableService.delete(entity_id).subscribe(() => {
      this.refresh();
    });
  }

  refresh(): void {
    window.location.reload();
  }
}
