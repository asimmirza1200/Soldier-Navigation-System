import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule }    from '@angular/common/http';
import { AngularFireModule } from '@angular/fire';
import { AngularFireDatabaseModule } from '@angular/fire/database';
import { environment } from '../environments/environment';
import { AppComponent } from './app.component';
import { NavMainComponent } from './nav-main/nav-main.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { AboutComponent } from './pages/about/about.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { AppRoutingModule } from "./app-routing.module";
 import { PatientlistComponent } from './pages/patientlist/patientlist.component';
 import { DoctorlistComponent } from './pages/doctorlist/doctorlist.component';
 import { FormsModule } from '@angular/forms';
 import { ReactiveFormsModule } from '@angular/forms';
 import{AngularFireMessagingModule}from'@angular/fire/messaging'; 
 import { AsyncPipe } from '@angular/common';

 import { 
	IgxAvatarModule,
	IgxFilterModule,
	IgxIconModule,
	IgxListModule,
	IgxInputGroupModule,
	IgxButtonGroupModule

 } from "igniteui-angular";
import { ShowpatientComponent } from './pages/showpatient/showpatient.component';
import { ChartsModule } from 'ng2-charts';
import { AddDoctorComponent } from './pages/add-doctor/add-doctor.component';
import { AddPatientComponent } from './pages/add-patient/add-patient.component';
import { ShowdoctorComponent } from './pages/showdoctor/showdoctor.component';
import { AssigndoctorComponent } from './pages/assigndoctor/assigndoctor.component';
import { LoginComponent } from './login/login.component';
import { AssignpatientComponent } from './pages/assignpatient/assignpatient.component';
import { SeeassignpatientsComponent } from './pages/seeassignpatients/seeassignpatients.component';
import { SeeassigndoctorsComponent } from './pages/seeassigndoctors/seeassigndoctors.component';
import { MessagingService } from './shared/messaging.service';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [
    AppComponent,
    NavMainComponent,
    AboutComponent,
    DashboardComponent,
    PatientlistComponent,
    DoctorlistComponent,
    ShowpatientComponent,
    AddDoctorComponent,
    AddPatientComponent,
    ShowdoctorComponent,
    AssigndoctorComponent,
    LoginComponent,
    AssignpatientComponent,
    SeeassignpatientsComponent,
    SeeassigndoctorsComponent,

  ],
  imports: [
    BrowserModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatCardModule,
    MatIconModule,
    AppRoutingModule,
		IgxAvatarModule,
	IgxFilterModule,
	IgxIconModule,
	IgxListModule,
	IgxInputGroupModule,
	IgxButtonGroupModule,
    FormsModule,
    MatListModule,
    RouterModule,
    ChartsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    AngularFireDatabaseModule,
    AngularFireMessagingModule,
    ToastrModule.forRoot()

  ],
  exports: [RouterModule],
  providers: [MessagingService,AsyncPipe],
    bootstrap: [AppComponent]
})
export class AppModule { }
