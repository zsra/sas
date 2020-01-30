import { Component, OnInit } from '@angular/core';
import { ExamResponseDTO } from 'src/app/dto/response/examResponseDTO';
import { Exam } from 'src/app/model/exam';
import { UserService } from 'src/app/service/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ExamService } from 'src/app/service/exam.service';
import { StudentService } from 'src/app/service/student.service';

@Component({
  selector: 'app-update-exam',
  templateUrl: './update-exam.component.html',
  styleUrls: ['./update-exam.component.scss']
})
export class UpdateExamComponent implements OnInit {

  id: number;
  currentUser: any = {};
  isDataLoaded: boolean  = false;
  response = new ExamResponseDTO();
  exam = new Exam();

  constructor(private userService: UserService, private router: Router, 
    private examService: ExamService,  private studentService: StudentService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data;
      this.examService.findById(this.id).subscribe(data => {
        this.exam = data;
        this.isDataLoaded = true;
      });
    });
  }

  isDataChanged() {
    if(!this.response.mark 
      || !this.response.written_at) return true;
    return false;
  }

  onSubmit() {
    if(this.isDataChanged) {
      this.response.course_id = this.exam.course.id;
      this.response.student_id = this.exam.student.id;
      if(!this.response.mark) this.response.mark = this.exam.mark;
      if(!this.response.written_at) this.response.written_at = this.exam.writtenAt;
      this.examService.update(this.id, this.response).subscribe(); 
    }
    this.goBack();
  }

  goBack() {
    this.router.navigate(['/exam/list', this.exam.student.id]);
  }

  userRole(): string {
    return this.currentUser.authorities[0].authority + '';
  }

}
