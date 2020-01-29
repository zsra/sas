import { Component, OnInit } from '@angular/core';
import { TimeTableEntity } from 'src/app/model/timeTableEntity';
import { Observable } from 'rxjs';
import { Classroom } from 'src/app/model/classroom';
import { TimeTableEntityResponseDTO } from 'src/app/dto/response/timeTableEntityResponseDTO';
import { UserService } from 'src/app/service/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ClassroomService } from 'src/app/service/classroom.service';
import { TimeTableService } from 'src/app/service/timeTable.service';

@Component({
  selector: 'app-timetable-entity-update',
  templateUrl: './timetable-entity-update.component.html',
  styleUrls: ['./timetable-entity-update.component.scss']
})
export class TimetableEntityUpdateComponent implements OnInit {

  id: number;
  admin: any = {};
  isDataAvailable: boolean = false;
  selectedOptionClassroom: any = {};
  classrooms: Observable<Classroom[]>;
  response = new TimeTableEntityResponseDTO();
  timeTableEntity = new TimeTableEntity();

  constructor(private userService: UserService, private router: Router, private route: ActivatedRoute,
    private classroomService: ClassroomService, private timeTableService: TimeTableService) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.admin = data;
      this.classroomService.findAll().subscribe(data => {
        this.classrooms = data;
        this.timeTableService.findById(this.id).subscribe(data => {
          this.timeTableEntity = data;
          this.isDataAvailable = true;
        });
      });
    });
  }

  isDataChanged() {
    if(!this.response.classroomNumber
      || !this.response.classroom_id
      || !this.response.day
      || !this.response.lessonNumber) return true;
      return false;
  }

  onSubmit() {
    if(this.isDataChanged) {
      this.response.course_id = this.timeTableEntity.course.id;
      if(!this.response.classroomNumber) this.response.classroomNumber = this.timeTableEntity.classroomNumber;
      if(!this.response.day) this.response.day = this.timeTableEntity.day;
      if(!this.response.lessonNumber) this.response.lessonNumber = this.timeTableEntity.lessonNumber;
      this.response.classroom_id = this.selectedOptionClassroom.id;
      if(!this.response.classroom_id) this.response.classroom_id = this.timeTableEntity.classroom.id;
      this.timeTableService.update(this.id, this.response).subscribe();
      this.goBack(this.response.course_id);
    }
  }

  goBack(course_id: number) {
    this.router.navigate(['/timetable/course', course_id]);
  }

  userRole(): string {
    return this.admin.authorities[0].authority + '';
  }

}
