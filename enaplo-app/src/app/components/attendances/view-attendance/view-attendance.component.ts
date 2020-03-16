import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Attendance } from 'src/app/model/attendance';
import { UserService } from 'src/app/service/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { AttendanceService } from 'src/app/service/attendace.service';
import { StudentService } from 'src/app/service/student.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { isStudent, isIdMatches } from 'src/app/shared/roles';

@Component({
  selector: 'app-view-attendance',
  templateUrl: './view-attendance.component.html',
  styleUrls: ['./view-attendance.component.scss']
})
export class ViewAttendanceComponent implements OnInit {

  student_id: number;
  searchText;
  isDataAvailable: boolean = false;
  currentUser: any = {};
  attendances: Observable<Attendance[]>;

  constructor(private userService: UserService, private router: Router, private route: ActivatedRoute, 
    private attendanceService: AttendanceService, private studentService: StudentService, private _snackBar: MatSnackBar) { }

  ngOnInit() {
    this.student_id = this.route.snapshot.params['id'];
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data;
      this.attendanceService.getAllByStudent(this.student_id).subscribe(data => {
        this.attendances = data;
        this.isDataAvailable = true;
      }); 
    });
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 2000,
    });
  }

  userRole() {
    return !isStudent(this.currentUser, this.router)
    || isIdMatches(this.currentUser, this.router, this.student_id, this.studentService);
  }

  delete(attendace_id: number) {
    this.attendanceService.delete(attendace_id).subscribe(() => {
      this.openSnackBar('Attendance deleted.', 'Ok');
    }, error => {
      this.openSnackBar('Failed.', 'Ok');
    });
  }

  goBack() {
    this.studentService.findById(this.student_id).subscribe(data => {
      this.router.navigate(['student/classroom', data.classroom.id]);
    });
  }
}
