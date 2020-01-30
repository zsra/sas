import { Component, OnInit, OnDestroy } from '@angular/core';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-panel-loader',
  templateUrl: './panel-loader.component.html',
  styleUrls: ['./panel-loader.component.scss']
})
export class PanelLoaderComponent implements OnInit, OnDestroy {

  user: any = {};

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getMyInfo().toPromise().then(data =>  {
      this.user = data;
    });
  }

  ngOnDestroy() {
    this.user = null;
  }

  userRole(): string {
    return this.user.authorities[0].authority + '';
  }

}
