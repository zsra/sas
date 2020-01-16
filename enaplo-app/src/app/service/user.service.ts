import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {ConfigService} from './config.service';
import {map} from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class UserService {

    currentUser;

    constructor(private apiService: ApiService, private configService: ConfigService) {

    }

    initUser() {
        const PROMISE = this.apiService.get(this.configService.getRefreshTokenUrl)
            .toPromise()
            .then(response => {
                if(response.access_token !== null) {
                    return this.getMyInfo()
                        .toPromise()
                        .then(user => {
                            this.currentUser = user;
                        })
                }
            }).catch(() => null);
        return PROMISE;
    }

    getMyInfo() {
        return this.apiService.get(this.configService.getWhoami)
            .pipe(map(user => this.currentUser = user ));
    }

    getAll() {
        return this.apiService.get(this.configService.getAllUsersUrl);
    }
}