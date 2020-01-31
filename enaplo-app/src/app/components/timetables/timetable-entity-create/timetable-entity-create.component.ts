import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Classroom } from 'src/app/model/classroom';
import { TimeTableEntityResponseDTO } from 'src/app/dto/response/timeTableEntityResponseDTO';
import { UserService } from 'src/app/service/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ClassroomService } from 'src/app/service/classroom.service';
import { TimeTableService } from 'src/app/service/timeTable.service';

@Component({
  selector: 'app-timetable-entity-create',
  templateUrl: './timetable-entity-create.component.html',
  styleUrls: ['./timetable-entity-create.component.scss']
})
export class TimetableEntityCreateComponent implements OnInit {

  id: number;
  currentUser: any = {};
  isDataAvailable: boolean = false;
  selectedOptionClassroom: any = {};
  classrooms: Observable<Classroom[]>;
  timeTableEntity = new TimeTableEntityResponseDTO();

  constructor(private userService: UserService, private router: Router, private route: ActivatedRoute,
    private classroomService: ClassroomService, private timeTableService: TimeTableService) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data;
      this.classroomService.findAll().subscribe(data => {
        this.classrooms = data;
        this.isDataAvailable = true;
      });
    });
  }

  reset() {
    this.timeTableEntity = new TimeTableEntityResponseDTO();
    this.isDataAvailable = false;
    this.selectedOptionClassroom = {};
  }

  onSubmit() {
    this.timeTableEntity.course_id = this.id;
    this.timeTableService.create(this.id, this.timeTableEntity).subscribe(() => {
      this.reset();
    });
  }

  goBack() {
    this.router.navigate(['/timetable/course', this.id]);
  }
  
  refresh(): void {
    window.location.reload();
  }

  userRole(): string {
    return this.currentUser.authorities[0].authority + '';
  }

}
