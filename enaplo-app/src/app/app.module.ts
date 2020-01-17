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
import { SummaryComponent } from './components/summary/summary.component';
import { HeaderComponent } from './components/header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './components/home/home.component';
import { AdminPanelComponent } from './components/panels/admin-panel/admin-panel.component';
import { TeacherPanelComponent } from './components/panels/teacher-panel/teacher-panel.component';
import { HeadteacherPanelComponent } from './components/panels/headteacher-panel/headteacher-panel.component';
import { StudentPanelComponent } from './components/panels/student-panel/student-panel.component';

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
    StudentPanelComponent
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
