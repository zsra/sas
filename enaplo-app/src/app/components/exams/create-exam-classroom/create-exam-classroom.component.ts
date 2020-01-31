import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Course } from 'src/app/model/course';
import { ExamDTO } from 'src/app/dto/examDTO';
import { ExamResponseDTO } from 'src/app/dto/response/examResponseDTO';
import { UserService } from 'src/app/service/user.service';
import { CourseService } from 'src/app/service/course.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ExamService } from 'src/app/service/exam.service';
import { ClassroomService } from 'src/app/service/classroom.service';
import { TeacherService } from 'src/app/service/teacher.service';
import { Teacher } from 'src/app/model/teacher';

@Component({
  selector: 'app-create-exam-classroom',
  templateUrl: './create-exam-classroom.component.html',
  styleUrls: ['./create-exam-classroom.component.scss']
})
export class CreateExamClassroomComponent implements OnInit {

  classroom_id: number;
  currentUser: any = {};
  isDataAvailable: boolean = false;
  isBasicSet: boolean = false;
  courses: Observable<Course[]>;
  exams: Observable<ExamDTO[]>;
  raw_exams: ExamDTO[];
  response: ExamResponseDTO[];
  marks: any = {};
  written_at: any = {};
  selectedCourse: any = {};

  constructor(private userService: UserService, private courseService: CourseService, private router: Router,
    private examService: ExamService, private classroomService: ClassroomService, private teacherService: TeacherService, 
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.classroom_id = this.route.snapshot.params['id'];
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

  setBasic() {
    this.examService.makeExamsFormToClassroom(this.classroom_id, this.written_at).subscribe(data => {
      this.exams = data;  
      this.raw_exams = data;
      this.isBasicSet = true;
    });
  }

  onSubmit() {
    this.examService.createExamsFromForm(this.collect(this.marks, this.raw_exams, this.selectedCourse.id, this.written_at))
    .subscribe(data =>  {     
      this.goBack();

    });
  }

  collect(marks: number[], entities: ExamDTO[], course_id: number, 
    written_at: string): ExamResponseDTO[] {
    var index = 0;
    var result: ExamResponseDTO[] = [];
  
    for(let entity of entities) {
      result.push(new ExamResponseDTO());
      result[index].course_id = course_id;
      result[index].student_id = entity.student.id;
      result[index].written_at = written_at;
      if(marks[index] != null) {
        result[index].mark = marks[index];
      } else {
        result[index].mark = 0;
      }    
      index++;
    }

    return result;
  }

  goBack() {
    this.router.navigate(['classroom/all']);
  }

  isTeacher() {
    return this.currentUser.authorities[0].authority + '' === 'ROLE_TEACHER' 
    || this.currentUser.authorities[0].authority + '' === 'ROLE_HEADTEACHER'; 
  }

}
