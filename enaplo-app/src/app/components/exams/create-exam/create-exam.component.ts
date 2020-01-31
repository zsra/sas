import { Component, OnInit } from '@angular/core';
import { ExamResponseDTO } from 'src/app/dto/response/examResponseDTO';
import { UserService } from 'src/app/service/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ExamService } from 'src/app/service/exam.service';
import { CourseService } from 'src/app/service/course.service';
import { Observable } from 'rxjs';
import { Course } from 'src/app/model/course';
import { StudentService } from 'src/app/service/student.service';
import { Classroom } from 'src/app/model/classroom';
import { TeacherService } from 'src/app/service/teacher.service';

@Component({
  selector: 'app-create-exam',
  templateUrl: './create-exam.component.html',
  styleUrls: ['./create-exam.component.scss']
})
export class CreateExamComponent implements OnInit {

  exam_id: number;
  currentUser: any = {};
  isDataAvailable: boolean  = false;
  exam = new ExamResponseDTO();
  courses: Observable<Course[]>;
  selectedOption: any = {};
  classroom = new Classroom();

  constructor(private userService: UserService, private router: Router, private examService: ExamService, private teacherService: TeacherService, 
    private courseService: CourseService, private studentService: StudentService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.exam_id = this.route.snapshot.params['id'];
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data;
      this.teacherService.findByUserId(this.currentUser.id).subscribe(data => {
        this.courseService.getCoursesByTeacherId(data.id).subscribe(data => {
          this.courses = data;
          this.isDataAvailable = true;
        });
      });
    });
  }

  onSubmit() {
    this.exam.student_id = this.exam_id;
    this.exam.course_id = this.selectedOption.id;
    this.examService.create(this.exam).subscribe(() => {
      this.goBack();
    });
  }

  goBack() {
    this.studentService.findById(this.exam_id).subscribe(data => {
      this.router.navigate(['/student/classroom', data.classroom.id]);
    });
  }

  userRole(): string {
    return this.currentUser.authorities[0].authority + '';
  }
}
