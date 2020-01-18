import { Component, OnInit } from '@angular/core';
import { SummaryDTO } from 'src/app/dto/summaryDTO';
import { Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from 'src/app/service/student/student.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.scss']
})
export class SummaryComponent implements OnInit {

  summary: Observable<SummaryDTO[]>;



  constructor(private activatedRoute: ActivatedRoute, private router: Router, 
    private studentService: StudentService, private userService: UserService) { }

  ngOnInit() {
    const user = this.userService.currentUser;
    console.log(this.userService.currentUser);
  }

}
