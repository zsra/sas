import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import { AdminGuard } from './guard/admin.guard';
import { LoginGuard } from './guard/login.guard';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { ForbiddenComponent } from './components/forbidden/forbidden.component';
import { SummaryComponent } from './components/students/summary/summary.component';
import { HomeComponent } from './components/home/home.component';
import { AdminPanelComponent } from './components/panels/admin-panel/admin-panel.component';
import { TeacherPanelComponent } from './components/panels/teacher-panel/teacher-panel.component';
import { StudentPanelComponent } from './components/panels/student-panel/student-panel.component';
import { HeadteacherPanelComponent } from './components/panels/headteacher-panel/headteacher-panel.component';
import { UserListComponent } from './components/users/user-list/user-list.component';
import { StudentDetailsComponent } from './components/students/student-details/student-details.component';
import { TeacherDetailsComponent } from './components/teachers/teacher-details/teacher-details.component';
import { StudentCreateComponent } from './components/students/student-create/student-create.component';
import { TeacherCreateComponent } from './components/teachers/teacher-create/teacher-create.component';

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
  /* ----- ADMIN - USER MANAGEMENT ----- */
  {
    path: 'user/list',
    component: UserListComponent
  },

  /* ---- STUDENT -----*/
  {
    path: 'student/details/:id',
    component: StudentDetailsComponent
  },
  {
    path: 'student/create',
    component: StudentCreateComponent
  },
  {
    path: 'summary',
    component: SummaryComponent
  },
  /* ---- TEACHER ----- */
  {
    path: 'teacher/create',
    component: TeacherCreateComponent
  },
  {
    path: 'teacher/details/:id',
    component: TeacherDetailsComponent
  },
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
