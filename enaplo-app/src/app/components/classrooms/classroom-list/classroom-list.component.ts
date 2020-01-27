import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Classroom } from 'src/app/model/classroom';
import { ClassroomService } from 'src/app/service/classroom.service';
import { UserService } from 'src/app/service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-classroom-list',
  templateUrl: './classroom-list.component.html',
  styleUrls: ['./classroom-list.component.scss']
})
export class ClassroomListComponent implements OnInit {

  searchText;
  classrooms: Observable<Classroom[]>;
  isDataAvailable:boolean = false;
  user: any;

  constructor(private userService: UserService, private router: Router,
    private classroomService: ClassroomService) { }

  ngOnInit() {
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.user = data;
      this.classroomService.findAll().subscribe(data =>
        this.classrooms = data);
    }).then(() => this.isDataAvailable = true);
  }

  userRole(): string {
    return this.user.authorities[0].authority + '';
  }

  update(classroom_id: number) {
    this.classroomService.findById(classroom_id).subscribe(
      data => this.router.navigate(['/classroom/update', data.id])
    );
  }

  delete(classroom_id: number) {

  }
}
