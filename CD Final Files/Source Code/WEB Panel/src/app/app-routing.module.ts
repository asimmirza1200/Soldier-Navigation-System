import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { BrowserModule } from "@angular/platform-browser";
import { Routes, RouterModule } from "@angular/router";
import { AboutComponent } from './pages/about/about.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { DoctorlistComponent } from './pages/doctorlist/doctorlist.component';
import { PatientlistComponent } from './pages/patientlist/patientlist.component';
import { ShowpatientComponent } from './pages/showpatient/showpatient.component';
import { AddDoctorComponent } from './pages/add-doctor/add-doctor.component';
import { AddPatientComponent } from './pages/add-patient/add-patient.component';
import { ShowdoctorComponent } from './pages/showdoctor/showdoctor.component';
import { AssigndoctorComponent } from './pages/assigndoctor/assigndoctor.component';
import { LoginComponent } from './login/login.component';
import { AssignpatientComponent } from './pages/assignpatient/assignpatient.component';
import { SeeassignpatientsComponent } from './pages/seeassignpatients/seeassignpatients.component';
import { SeeassigndoctorsComponent } from './pages/seeassigndoctors/seeassigndoctors.component';

const routes: Routes = [
  {
    path: "",
    redirectTo: "login",
    pathMatch: "full",
    data:{title:'Login'}

  },
  { 
    path: "patientlist",
    component: PatientlistComponent,
    data:{title:'Patient List'}

  }
,
  { 
    path: "doctorlist",
    component: DoctorlistComponent,
    data:{title:'Doctor List'}
  }
,
{ 
  path: "showpatient",
  component: ShowpatientComponent,
  data:{title:'Show Patient'}
}
,
{ 
  path: "adddoctor",
  component: AddDoctorComponent,
  data:{title:'Add Doctor'}
}
,
{ 
  path: "addpatient",
  component: AddPatientComponent,
  data:{title:'Add Patient'}
}
,
{ 
  path: "showdoctor",
  component: ShowdoctorComponent,
  data:{title:'Show Doctor'}
}
,
{ 
  path: "seeassignpatients",
  component: SeeassignpatientsComponent,
  data:{title:'See Assign Patients'}
}
,
{ 
  path: "seeassigndoctors",
  component: SeeassigndoctorsComponent,
  data:{title:'See Assign Doctors'}
}
,
{ 
  path: "assigndoctor",
  component: AssigndoctorComponent,
  data:{title:'Assign Doctor'}
},
{ 
  path: "assignpatient",
  component: AssignpatientComponent,
  data:{title:'Assign Patient'}
}
,
  { 
    path: "dashboard",
    component: DashboardComponent,
    data:{title:'Dashboard'}

  }
  ,
  { 
    path: "login",
    component: LoginComponent,
    data:{title:'Login'}

  }
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes, {
      useHash: true
    })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
