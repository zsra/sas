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
    private getUserByIdUrl = this.userUrl;

    get getWhoami(): string {
        return this.whoamiUrl;
    }

    get getAllUsersUrl(): string {
        return this.allUsersUrl;
    }

    get getCreateUrl(): string {
        return this.createUrl;
    }

    get getGetUserByIdUrl(): string {
        return this.getUserByIdUrl;
    }

    private studentUrl = this.baseUrl + '/students';           
    private studentAllUrl = this.studentUrl + '/all'; 
    private studentByIdUrl = this.studentUrl;
    private studentByUserIdUrl = this.studentUrl + '/user';  
    private createStudentUrl =  this.studentUrl + '/create';  
    private updateStudentUrl = this.studentUrl + '/update';
    private deleteStudentUrl = this.studentUrl;
    private summaryStudentUrl = this.studentUrl + '/summary';
    
    get getStudentAllUrl(): string {
        return this.studentAllUrl;
    }

    get getStudentByUserIdUrl(): string {
        return this.studentByUserIdUrl;
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

    private attendanceUrl = this.baseUrl + '/attendances';
    private makeAttendanceFormToClassroomUrl = this.attendanceUrl;
    private createAttendanceUrl = this.attendanceUrl + '/create';
    private verifyAttendanceUrl = this.attendanceUrl + '/verify';
    private nonVerifyAttendanceUrl = this.attendanceUrl + '/nonVerify';
    private allAttendanceByStudentUrl = this.attendanceUrl + '/all';
    private deleteAttendaceUrl = this.attendanceUrl;

    get getMakeAttendanceFormToClassroomUrl(): string {
        return this.makeAttendanceFormToClassroomUrl;
    }

    get getCreateAttendanceUrl(): string {
        return this.createAttendanceUrl;
    }

    get getVerifyAttendanceUrl(): string {
        return this.verifyAttendanceUrl;
    }

    get getNonVerifyAttendanceUrl(): string {
        return this.nonVerifyAttendanceUrl;
    }

    get getAllAttendanceByStudentUrl(): string {
        return this.allAttendanceByStudentUrl;
    }

    get getDeleteAttendaceUrl(): string {
        return this.deleteAttendaceUrl;
    }

    private classroomUrl = this.baseUrl + '/classrooms';
    private allClassroomUrl = this.classroomUrl + '/all';
    private createClassroomUrl = this.classroomUrl + '/create';
    private updateClassroomUrl = this.classroomUrl + '/update';
    private deleteClassroomUrl = this.classroomUrl;
    private getStudentsFromClassroomUrl = this.classroomUrl + '/students';
    private setCourseUrl = this.classroomUrl + '/setCourse';
    private getClassroomByIdUrl = this.classroomUrl;

    get getAllClassroomUrl(): string {
        return this.allClassroomUrl;
    }

    get getCreateClassroomUrl(): string {
        return this.createClassroomUrl;
    }

    get getUpdateClassroomUrl(): string {
        return this.updateClassroomUrl;
    }

    get getDeleteClassroomUrl(): string {
        return this.deleteClassroomUrl;
    }

    get getGetStudentsFromClassroomUrl(): string {
        return this.getStudentsFromClassroomUrl;
    }

    get getSetCourseUrl(): string {
        return this.setCourseUrl;
    }

    get getGetClassroomByIdUrl(): string {
        return this.getClassroomByIdUrl;
    }

    private courseUrl = this.baseUrl + '/courses';
    private createCourseUrl = this.courseUrl + '/create';
    private updateCourseUrl = this.courseUrl + '/update';
    private setCourseToStudentUrl = this.courseUrl + '/setCourse';
    private deleteCourseUrl = this.courseUrl;
    private getCourseByIdUrl = this.courseUrl;
    private getAllCoursesUrl = this.courseUrl + '/all';

    get getCreateCourseUrl(): string {
        return this.createCourseUrl;
    }

    get getUpdateCourseUrl(): string {
        return this.updateCourseUrl;
    }

    get getSetCourseToStudentUrl(): string {
        return this.setCourseToStudentUrl;
    }
    
    get getDeleteCourseUrl(): string {
        return this.deleteCourseUrl;
    }

    get getGetCourseByIdUrl(): string {
        return this.getCourseByIdUrl;
    }

    get getGetAllCoursesUrl(): string {
        return this.getAllCoursesUrl;
    }

    private examUrl = this.baseUrl + '/exams';
    private examfindAllByStudent = this.examUrl + '/student';
    private createExamUrl = this.examUrl + '/create';
    private updateExamUrl = this.examUrl + '/update';
    private deleteExamUrl = this.examUrl;
    private createExamsFromForm = this.examUrl + 'form/create';
    private makeExamsFormToClassroom = this.examUrl + '/form';

    get getExamfindAllByStudent(): string {
        return this.examfindAllByStudent;
    }

    get getCreateExamUrl(): string {
        return this.createExamUrl;
    }

    get getUpdateExamUrl(): string {
        return this.updateExamUrl;
    }

    get getDeleteExamUrl(): string {
        return this.deleteExamUrl;
    }

    get getCreateExamsFromForm(): string {
        return this.createExamsFromForm;
    }

    get getMakeExamsFormToClassroom(): string {
        return this.makeExamsFormToClassroom;
    }

    private reportUrl = this.baseUrl + '/reports';
    private getSemesterResultByStudentUrl = this.reportUrl;
    private createrReportUrl = this.reportUrl + '/create';
    private updateReportUrl = this.reportUrl + '/update';
    private deletereportUrl = this.reportUrl;
    private makeReportFormToClassroomUrl = this.reportUrl + '/form';
    private createReportsToClassroomUrl = this.reportUrl + '/form/create';

    get getGetSemesterResultByStudentUrl(): string {
        return this.getSemesterResultByStudentUrl;
    }

    get getCreateReportUrl(): string {
        return this.createrReportUrl;
    }

    get getUpdateReportUrl(): string {
        return this.updateReportUrl;
    }

    get getDeleteReportUrl(): string {
        return this.deletereportUrl;
    }

    get getMakeReportFormToClassroomUrl(): string {
        return this.makeReportFormToClassroomUrl;
    }

    get getCreateReportsToClassroomUrl(): string {
        return this.createReportsToClassroomUrl;
    }

    private teacherUrl = this.baseUrl + '/teachers';
    private findAllTeacherUrl = this.teacherUrl + '/all';
    private findTeacherById = this.teacherUrl;
    private findTeacherByUserId = this.teacherUrl + '/user';
    private createTeacherUrl = this.teacherUrl + '/create';
    private updateTeacherUrl = this.teacherUrl + '/update';
    private setCourseToTeacherUrl = this.teacherUrl + '/setCourse';
    private deleteTeacherUrl = this.teacherUrl;

    get getFindAllTeacherUrl(): string {
        return this.findAllTeacherUrl;
    }

    get getFindTeacherById(): string {
        return this.findTeacherById;
    }

    get getFindTeacherByUserId(): string {
        return this.findTeacherByUserId;
    }

    get getCreateTeacherUrl(): string {
        return this.createTeacherUrl;
    }

    get getUpdateTeacherUrl(): string {
        return this.updateTeacherUrl;
    }

    get getSetCourseToTeacherUrl(): string {
        return this.setCourseToTeacherUrl;
    }

    get getDeleteTeacherUrl(): string {
        return this.deleteTeacherUrl;
    }

    private timetableUrl = this.baseUrl + '/timetables';
    private createTimeTableUrl = this.timetableUrl + '/create';
    private updateTimeTableUrl = this.timetableUrl + '/update';
    private deleteTimeTableUrl = this.timetableUrl;
    private getTimeTableByStudentUrl = this.timetableUrl + '/student';
    private getTimeTableByTeacherUrl = this.timetableUrl + '/teacher';

    get getCreateTimeTableUrl(): string {
        return this.createTimeTableUrl;
    }

    get getUpdateTimeTableUrl(): string {
        return this.updateTimeTableUrl;
    }

    get getDeleteTimeTableUrl(): string {
        return this.deleteTimeTableUrl;
    }

    get getGetTimeTableByStudentUrl(): string {
        return this.getTimeTableByStudentUrl;
    }

    get getGetTimeTableByTeacherUrl(): string {
        return this.getTimeTableByTeacherUrl;
    }
}