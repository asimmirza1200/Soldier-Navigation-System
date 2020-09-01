import { Component, OnInit, Inject  } from '@angular/core';
import { IgxToastComponent, IgxListComponent, IgxFilterOptions } from 'igniteui-angular';
import {ApiService} from './api.service';
import { Router } from '@angular/router';
import { DOCUMENT } from '@angular/common';

@Component({
  selector: 'app-assignpatient',
  templateUrl: './assignpatient.component.html',
  styleUrls: ['./assignpatient.component.css']
})
export class AssignpatientComponent implements OnInit {
  public searchpatient: string;
  public image="https://www.uidownload.com/files/802/144/19/vector-patient-design-elements-set-thumb.jpg"
  public patients;

  public density = "comfortable";
  public displayDensities;
  doctor: any;
  assignDoctor(body) {

    this._apiService.assignDoctor(body).subscribe(
       data => {
        console.log(data);
        this.document.location.reload();    

         // refresh the list
         return true;
       },
       error => {
        alert('Error!! :-)\n\n' +error)

         console.error(error);
         return false;
       }
    );
  }
  getDoctors() {
    this._apiService.getPatients().subscribe(
      // the first argument is a function which runs on success
      data => { console.log("Data:"+data.response)   
              this.patients=data.response
    },
      // the second argument is a function which runs on error
      err => console.error(err),
      // the third argument is a function which runs on completion
      () => console.log('done loading foods')
    );
  }

 constructor(private _apiService: ApiService, private _router: Router, @Inject(DOCUMENT) private document: Document){
  this. doctor=history.state.doctor;
  if(localStorage.getItem('isloggedin')!="yes"){
    this._router.navigateByUrl('/login');
  
   }
  if(this.doctor==null){
    this._router.navigateByUrl('/doctorlist');

  }
this.getDoctors()
 }
 
  public ngOnInit() {

     

    this.displayDensities = [
        { label: "comfortable", selected: this.density === "comfortable", togglable: true },
        { label: "cosy", selected: this.density === "cosy", togglable: true },
        { label: "compact", selected: this.density === "compact", togglable: true }
    ];
  }

  public selectDensity(event) {
    this.density = this.displayDensities[event.index].label;
  }

  
  public click(patient: any) {
    //this._router.navigateByUrl('/patientlist');

    if(confirm("Are you sure to assign "+patient.patientname)) {
      this.assignDoctor({patient_id:patient._id,doctor_id:this.doctor._id})
    }
  }
  get filterpatients() {
    const fo = new IgxFilterOptions();
    fo.key = "patientname";

    fo.inputValue = this.searchpatient;
    return fo;
  }
}
