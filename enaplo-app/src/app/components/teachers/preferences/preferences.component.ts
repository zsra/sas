import { Component, OnInit } from '@angular/core';
import { TeacherPreference } from 'src/app/model/teacherPreference';
import { TeacherPreferenceResponseDTO } from 'src/app/dto/response/teacherPreferenceResponseDTO';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user.service';
import { TeacherService } from 'src/app/service/teacher.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Teacher } from 'src/app/model/teacher';

@Component({
  selector: 'app-preferences',
  templateUrl: './preferences.component.html',
  styleUrls: ['./preferences.component.scss']
})
export class PreferencesComponent implements OnInit {

  currentUser: any = {};
  isDataAvailable: boolean = false;
  preferencesOrigin = new TeacherPreference();
  preferences = new TeacherPreferenceResponseDTO();
  teacher = new Teacher();
  underModifying: Boolean = false;

  constructor(private userService: UserService, private teacherService: TeacherService, private _snackBar: MatSnackBar,
    private router: Router) { }

  ngOnInit() {
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data;
      this.teacherService.findByUserId(this.currentUser.id).subscribe(data => {
        this.teacher = data;
        this.teacherService.getAllTeacherPreferences(this.teacher.id).subscribe(data => { 
          this.preferencesOrigin = data;
          this.preferences = data;
          this.isDataAvailable = true;
        });
      });
    });
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 2000,
    });
  }

  isDataChanged() {
    if(!(this.preferencesOrigin.homeworkWeight == this.preferencesOrigin.homeworkWeight) ||
    !(this.preferencesOrigin.topicTestWeight == this.preferencesOrigin.topicTestWeight) ||
    !(this.preferencesOrigin.testWeight == this.preferencesOrigin.testWeight) ||
    !(this.preferencesOrigin.repetitionWeight == this.preferencesOrigin.repetitionWeight)) return true;
    return false;
  }

  onSubmit() {
    if(this.isDataChanged && this.underModifying) {
      this.teacherService.setTeacherPreferences(this.preferences).subscribe(() => {
        this.openSnackBar('Preferences updated', 'Ok');
        this.refresh();
      });
    }
  }

  refresh(): void {
    window.location.reload();
  }

  userRole(): string {
    return this.currentUser.authorities[0].authority + '';
  }

  goBack() {
    this.underModifying = false;
    this.refresh();
  }

  modify() {
    this.underModifying = true;
  }
}
