import {Injectable} from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class ConfigService {

    private baseUrl = '/api';
    
    private refreshTokenUrl = this.baseUrl + '/refresh';
    private loginUrl = this.baseUrl + '/login'; 
    private logoutUrl = this.baseUrl + '/logout';
    private changePasswordUrl = this.baseUrl + '/changePassword';

    get getRefreshTokenUrl(): string {
        return this.refreshTokenUrl;
    }

    get getLoginUrl(): string {
        return this.loginUrl;
    }

    get getLogoutUrl(): string {
        return this.logoutUrl;
    }

    get getChangePasswordUrl(): string {
        return this.changePasswordUrl;
    }

    private userUrl = this.baseUrl + '/user';
    private whoamiUrl = this.userUrl + '/whoami';
    private allUsersUrl = this.userUrl + '/all';
    private createUrl = this.userUrl + '/create';

    get getWhoami(): string {
        return this.whoamiUrl;
    }

    get getAllUsersUrl(): string {
        return this.allUsersUrl;
    }

    get getCreateUrl(): string {
        return this.createUrl;
    }

    private studentUrl = this.baseUrl + '/students';
    private studentByUserIdUrl = this.studentUrl + '/user';
    private studentAllUrl = this.studentUrl + '/all';
    private createStudentUrl =  this.studentUrl + '/create';
    private studentByIdUrl = this.studentUrl;
    private updateStudentUrl = this.studentUrl + '/update';
    private deleteStudentUrl = this.studentUrl;
    private summaryStudentUrl = this.studentUrl + '/summary';
    
    get getStudentAllUrl(): string {
        return this.studentAllUrl;
    }

    get getStudentByUserIdUrl(): string {
        return this.getStudentByUserIdUrl;
    }

    get getCreateStudentUrl(): string {
        return this.createStudentUrl;
    }

    get getStudentUrl(): string {
        return this.studentByIdUrl;
    }

    get getUpdateStudentUrl(): string {
        return this.updateStudentUrl;
    }

    get getDeleteStudentUrl(): string {
        return this.deleteStudentUrl;
    }

    get getSummaryStudentUrl(): string {
        return this.summaryStudentUrl;
    }
}