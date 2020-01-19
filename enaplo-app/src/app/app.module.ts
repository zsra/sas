import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { ForbiddenComponent } from './components/forbidden/forbidden.component';
import { LoginGuard } from './guard/login.guard';
import { AdminGuard } from './guard/admin.guard';
import { AuthService } from './service/auth.service';
import { ApiService } from './service/api.service';
import { UserService } from './service/user.service';
import { ConfigService } from './service/config.service';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SummaryComponent } from './components/students/summary/summary.component';
import { HeaderComponent } from './components/header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './components/home/home.component';
import { AdminPanelComponent } from './components/panels/admin-panel/admin-panel.component';
import { TeacherPanelComponent } from './components/panels/teacher-panel/teacher-panel.component';
import { HeadteacherPanelComponent } from './components/panels/headteacher-panel/headteacher-panel.component';
import { StudentPanelComponent } from './components/panels/student-panel/student-panel.component';
import { UserListComponent } from './components/users/user-list/user-list.component';
import { UserCreateComponent } from './components/users/user-create/user-create.component';
import { StudentDetailsComponent } from './components/students/student-details/student-details.component';
import { TeacherDetailsComponent } from './components/teachers/teacher-details/teacher-details.component';
import { TeacherListComponent } from './components/teachers/teacher-list/teacher-list.component';
import { TeacherCreateComponent } from './components/teachers/teacher-create/teacher-create.component';
import { StudentCreateComponent } from './components/students/student-create/student-create.component';
import { StudentUpdateComponent } from './components/students/student-update/student-update.component';
import { TeacherUpdateComponent } from './components/teachers/teacher-update/teacher-update.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NotFoundComponent,
    ForbiddenComponent,
    SummaryComponent,
    HeaderComponent,
    HomeComponent,
    AdminPanelComponent,
    TeacherPanelComponent,
    HeadteacherPanelComponent,
    StudentPanelComponent,
    UserListComponent,
    UserCreateComponent,
    StudentDetailsComponent,
    TeacherDetailsComponent,
    TeacherListComponent,
    TeacherCreateComponent,
    StudentCreateComponent,
    StudentUpdateComponent,
    TeacherUpdateComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [
    LoginGuard,
    AdminGuard,
    AuthService,
    ApiService,
    UserService,
    ConfigService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
