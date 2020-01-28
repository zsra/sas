import { Component, OnInit } from '@angular/core';
import { SummaryDTO } from 'src/app/dto/summaryDTO';
import { Observable } from 'rxjs';
import { UserService } from 'src/app/service/user.service';
import { StudentService } from 'src/app/service/student.service';
import { Student } from 'src/app/model/student';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-summary-student',
  templateUrl: './summary-student.component.html',
  styleUrls: ['./summary-student.component.scss']
})
export class SummaryStudentComponent implements OnInit {

  currentUser: any = {};
  student = new Student();
  summaries: Observable<SummaryDTO[]>;
  isDataAvailable: boolean  = false;
  id: number;

  constructor(private userService: UserService, private studentService: StudentService, 
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data;
      this.studentService.findById(this.id).subscribe(data => {
        this.student = data;
        this.studentService.summary(this.student.id).subscribe(data => { 
          this.summaries = data;
          this.isDataAvailable = true;
        });
      }); 
    });
  }

  userRole(): string {
    return this.currentUser.authorities[0].authority + '';
  }


}
