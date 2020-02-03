import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Archive } from 'src/app/model/archive';
import { UserService } from 'src/app/service/user.service';
import { AdminService } from 'src/app/service/admin.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-archive-details',
  templateUrl: './archive-details.component.html',
  styleUrls: ['./archive-details.component.scss']
})
export class ArchiveDetailsComponent implements OnInit {

  archive_id: number;
  archive: Observable<Archive>;
  isDataAvailable:boolean = false;
  currentUser: any = {};

  constructor(private userService: UserService, private adminService: AdminService,
    private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.archive_id = this.route.snapshot.params['id'];
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.currentUser = data;
      this.adminService.getArchiveById(this.archive_id).subscribe(data => {
        this.archive = data;
        this.isDataAvailable = true;
      });
    });
  }

  userRole(): string {
    return this.currentUser.authorities[0].authority + '';
  }

  goBack() {
    this.router.navigate(['archive/all']);
  }

}
