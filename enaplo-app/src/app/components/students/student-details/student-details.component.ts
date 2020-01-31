import { Component, OnInit, OnDestroy } from '@angular/core';
import { Student } from 'src/app/model/student';
import { UserService } from 'src/app/service/user.service';
import { ActivatedRoute } from '@angular/router';
import { StudentService } from 'src/app/service/student.service';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.scss']
})
export class StudentDetailsComponent implements OnInit {

  currentUser: any = {};
  id: number = 0;
  student = new Student();
  isDataAvailable:boolean = false;

  constructor(private userService: UserService, private route: ActivatedRoute, 
    private studentService: StudentService) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data;
      this.studentService.findById(this.id).subscribe(data => { 
        this.student = data;
        this.isDataAvailable = true;
      });
    });
  }

  userRole(): string {
    return this.currentUser.authorities[0].authority + '';
  }

}
