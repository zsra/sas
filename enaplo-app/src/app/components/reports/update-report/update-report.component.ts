import { Component, OnInit } from '@angular/core';
import { Report } from 'src/app/model/report';
import { ReportResponseDTO } from 'src/app/dto/response/reportResponseDTO';
import { Observable } from 'rxjs';
import { Course } from 'src/app/model/course';
import { UserService } from 'src/app/service/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { TeacherService } from 'src/app/service/teacher.service';
import { ReportService } from 'src/app/service/report.service';
import { CourseService } from 'src/app/service/course.service';
import { StudentService } from 'src/app/service/student.service';

@Component({
  selector: 'app-update-report',
  templateUrl: './update-report.component.html',
  styleUrls: ['./update-report.component.scss']
})
export class UpdateReportComponent implements OnInit {

  report_id: number;
  currentUser: any = {};
  isDataAvailable: boolean  = false;
  report = new Report();
  response = new ReportResponseDTO();
  courses: Observable<Course[]>;
  selectedOption: any = {};

  constructor(private userService: UserService, private router: Router, private route: ActivatedRoute,
    private teacherService: TeacherService, private reportService: ReportService, 
    private courseService: CourseService, private studentService: StudentService) { }

  ngOnInit() {
    this.report_id = this.route.snapshot.params['id'];
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data; 
      this.teacherService.findByUserId(this.currentUser.id).subscribe(data => {
        this.courseService.getCoursesByTeacherId(data.id).subscribe(data => {
          this.courses = data;
          this.reportService.findByIdUrl(this.report_id).subscribe(data => {
            this.report = data;
            this.isDataAvailable = true;
          });
        });
      });
    });
  }

  isDataChanged() {
    if(!this.response.semester 
      || !this.response.year
      || !this.response.mark) return true;
    return false;
  }

  onSubmit() {
    if(this.isDataChanged()) {
      this.response.student_id = this.report.student.id;
      if(!this.selectedOption) this.response.courseName = this.selectedOption.title;
      else this.response.courseName = this.report.courseName;
      if(!this.response.semester) this.response.semester = this.report.semester;
      if(!this.response.year) this.response.year = this.report.year;
      if(!this.response.mark) this.response.mark = this.report.mark;
      this.reportService.update(this.report.id, this.response).subscribe(() => {
        this.goBack();
      });
    } else {
      this.goBack();
    }  
  }

  goBack() {
    this.router.navigate(['home']);
  }

  userRole(): string {
    return this.currentUser.authorities[0].authority + '';
  }

}
