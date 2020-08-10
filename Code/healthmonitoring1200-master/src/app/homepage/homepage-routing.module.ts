import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { BrowserModule } from "@angular/platform-browser";
import { Routes, RouterModule } from "@angular/router";
import { AboutComponent } from '../pages/about/about.component';
import { DashboardComponent } from '../pages/dashboard/dashboard.component';
import { DoctorlistComponent } from '../pages/doctorlist/doctorlist.component';
import { PatientlistComponent } from '../pages/patientlist/patientlist.component';
import { ShowpatientComponent } from '../pages/showpatient/showpatient.component';
import { AddDoctorComponent } from '../pages/add-doctor/add-doctor.component';
import { AddPatientComponent } from '../pages/add-patient/add-patient.component';
import { ShowdoctorComponent } from '../pages/showdoctor/showdoctor.component';
import { AssigndoctorComponent } from '../pages/assigndoctor/assigndoctor.component';
import { LoginComponent } from '../login/login.component';

export const HomePageRoutes: Routes = [
  {
    path: "",
    redirectTo: "dashboard",
    pathMatch: "full",
    data:{title:'dashboard'}

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
  path: "assigndoctor",
  component: AssigndoctorComponent,
  data:{title:'Assign Doctor'}
}
,
  { 
    path: "dashboard",
    component: DashboardComponent,
    data:{title:'Dashboard'}

  }
  
  
];

