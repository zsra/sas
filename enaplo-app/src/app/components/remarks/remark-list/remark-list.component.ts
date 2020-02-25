import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Remark } from 'src/app/model/remark';
import { RemarkService } from 'src/app/service/remark.service';
import { UserService } from 'src/app/service/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-remark-list',
  templateUrl: './remark-list.component.html',
  styleUrls: ['./remark-list.component.scss']
})
export class RemarkListComponent implements OnInit {

  remarks: Observable<Remark[]>;
  isDataAvailable: boolean = false;
  student_id: number;
  currentUser: any = {};

  constructor(private userService: UserService, private router: Router,
    private remarkService: RemarkService, private route: ActivatedRoute, private _snackBar: MatSnackBar) { }

  ngOnInit() {
    this.student_id = this.route.snapshot.params['id'];
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data;
      this.remarkService.findAll(this.student_id).subscribe(data => {
        this.remarks = data;
        this.isDataAvailable = true;
      });
    });
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 2000,
    });
  }

  userRole(): string {
    return this.currentUser.authorities[0].authority + '';
  }

  update(remark_id: number) {
    this.remarkService.findById(remark_id).subscribe(
      data => this.router.navigate(['/remark/update', data.id])
    );
  }

  delete(remark_id: number) {
    this.remarkService.delete(remark_id).subscribe(() => {
      this.refresh();
      this.openSnackBar('Remark deleted.', 'Ok');
    }, error => { this.openSnackBar('Failed.', 'Ok');});
  }
  
  refresh(): void {
    window.location.reload();
  }
}
