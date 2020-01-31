import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import { AdminGuard } from './guard/admin.guard';
import { LoginGuard } from './guard/login.guard';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { ForbiddenComponent } from './components/forbidden/forbidden.component';
import { HomeComponent } from './components/home/home.component';
import { AdminPanelComponent } from './components/panels/admin-panel/admin-panel.component';
import { TeacherPanelComponent } from './components/panels/teacher-panel/teacher-panel.component';
import { StudentPanelComponent } from './components/panels/student-panel/student-panel.component';
import { HeadteacherPanelComponent } from './components/panels/headteacher-panel/headteacher-panel.component';
import { UserListComponent } from './components/users/user-list/user-list.component';
import { StudentDetailsComponent } from './components/students/student-details/student-details.component';
import { StudentCreateComponent } from './components/students/student-create/student-create.component';
import { TeacherCreateComponent } from './components/teachers/teacher-create/teacher-create.component';
import { ClassroomListComponent } from './components/classrooms/classroom-list/classroom-list.component';
import { ClassroomCreateComponent } from './components/classrooms/classroom-create/classroom-create.component';
import { UserUpdateComponent } from './components/users/user-update/user-update.component';
import { StudentUpdateComponent } from './components/students/student-update/student-update.component';
import { CourseListComponent } from './components/courses/course-list/course-list.component';
import { CourseCreateComponent } from './components/courses/course-create/course-create.component';
import { CourseDetailsComponent } from './components/courses/course-details/course-details.component';
import { SummaryStudentComponent } from './components/students/summary-student/summary-student.component';
import { TeacherUpdateComponent } from './components/teachers/teacher-update/teacher-update.component';
import { SetCourseClassroomComponent } from './components/classrooms/set-course-classroom/set-course-classroom.component';
import { SetCourseComponent } from './components/courses/set-course/set-course.component';
import { CourseUpdateComponent } from './components/courses/course-update/course-update.component';
import { StudentClassroomListComponent } from './components/students/student-classroom-list/student-classroom-list.component';
import { TimetableEntityCreateComponent } from './components/timetables/timetable-entity-create/timetable-entity-create.component';
import { TimetableEntityUpdateComponent } from './components/timetables/timetable-entity-update/timetable-entity-update.component';
import { TimetableEntityViewComponent } from './components/timetables/timetable-entity-view/timetable-entity-view.component';
import { TimetableListComponent } from './components/timetables/timetable-list/timetable-list.component';
import { CreateExamClassroomComponent } from './components/exams/create-exam-classroom/create-exam-classroom.component';
import { CreateExamComponent } from './components/exams/create-exam/create-exam.component';
import { UpdateExamComponent } from './components/exams/update-exam/update-exam.component';
import { ExamListComponent } from './components/exams/exam-list/exam-list.component';
import { ClassroomUpdateComponent } from './components/classrooms/classroom-update/classroom-update.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  /* ----- USERS PANEL ----- */
  {
    path: 'admin',
    component: AdminPanelComponent
  },
  {
    path: 'teacher',
    component: TeacherPanelComponent
  },
  {
    path: 'student',
    component: StudentPanelComponent
  },
  {
    path: 'headteacher',
    component: HeadteacherPanelComponent
  },
  /* ----- USER ----- */
  {
    path: 'user/all',
    component: UserListComponent
  },
  {
    path: 'user/update/:id',
    component: UserUpdateComponent
  },

  /* ----- STUDENT -----*/
  {
    path: 'student/details/:id',
    component: StudentDetailsComponent
  },
  {
    path: 'student/create',
    component: StudentCreateComponent
  },
  {
    path: 'student/update/:id',
    component: StudentUpdateComponent
  }, 
  {
    path: 'student/summary/:id',
    component: SummaryStudentComponent
  },
  {
    path: 'student/classroom/:id',
    component: StudentClassroomListComponent
  },
  /* ----- TEACHER ----- */
  {
    path: 'teacher/create',
    component: TeacherCreateComponent
  },
  {
    path: 'teacher/update/:id',
    component: TeacherUpdateComponent
  },
  /* ----- CLASSROOM ----- */
  {
    path: 'classroom/all',
    component: ClassroomListComponent
  },
  {
    path: 'classroom/create',
    component: ClassroomCreateComponent
  },
  {
    path: 'classroom/update/:id',
    component: ClassroomUpdateComponent
  },
  {
    path: 'classroom/setCourse/:id',
    component: SetCourseClassroomComponent
  },
  /* ----- COURSE ----- */
  {
    path: 'course/all',
    component: CourseListComponent
  },
  {
    path: 'course/create',
    component: CourseCreateComponent
  },
  {
    path: 'course/details/:id',
    component: CourseDetailsComponent
  },
  {
    path: 'course/update/:id',
    component: CourseUpdateComponent
  },
  {
    path: 'course/setCourse/:id',
    component: SetCourseComponent
  },
  /* ----- TIMETABLE ----- */
  {
    path: 'timetable/create/:id',
    component: TimetableEntityCreateComponent
  },
  {
    path: 'timetable/update/:id',
    component: TimetableEntityUpdateComponent
  },
  {
    path: 'timetable/view/:id',
    component: TimetableEntityViewComponent
  },
  {
    path: 'timetable/course/:id',
    component: TimetableListComponent
  },
  /* ----- EXAM ----- */
  {
    path: 'exam/create/:id',
    component: CreateExamComponent
  },
  {
    path: 'exam/update/:id',
    component: UpdateExamComponent
  },
  {
    path: 'exam/classroom/:id',
    component: CreateExamClassroomComponent
  },
  {
    path: 'exam/list/:id',
    component: ExamListComponent
  },
  /* ----- DEFAULT ----- */
  {
    path: '404',
    component: NotFoundComponent
  },
  {
    path: '403',
    component: ForbiddenComponent
  },
  {
    path: '**',
    redirectTo: '/login'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule { }
