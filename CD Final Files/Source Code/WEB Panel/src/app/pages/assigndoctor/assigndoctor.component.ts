import { Component, OnInit, Inject  } from '@angular/core';
import { IgxToastComponent, IgxListComponent, IgxFilterOptions } from 'igniteui-angular';
import {ApiService} from './api.service';
import { Router } from '@angular/router';
import { DOCUMENT } from '@angular/common';
@Component({
  selector: 'app-assigndoctor',
  templateUrl: './assigndoctor.component.html',
  styleUrls: ['./assigndoctor.component.css']
})
export class AssigndoctorComponent implements OnInit {
  public searchdoctor: string;
  public image="https://www.uidownload.com/files/802/144/19/vector-doctor-design-elements-set-thumb.jpg"
  public doctors;

  public density = "comfortable";
  public displayDensities;
  patient: any;
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
    this._apiService.getDoctors().subscribe(
      // the first argument is a function which runs on success
      data => { console.log("Data:"+data.response)   
              this.doctors=data.response
    },
      // the second argument is a function which runs on error
      err => console.error(err),
      // the third argument is a function which runs on completion
      () => console.log('done loading foods')
    );
  }

 constructor(private _apiService: ApiService, private _router: Router, @Inject(DOCUMENT) private document: Document){
  this. patient=history.state.patient;
  if(localStorage.getItem('isloggedin')!="yes"){
    this._router.navigateByUrl('/login');
  
   }
  if(this.patient==null){
    this._router.navigateByUrl('/patientlist');

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

  
  public click(doctor: any) {
    //this._router.navigateByUrl('/doctorlist');

    if(confirm("Are you sure to assign "+doctor.doctorname)) {
      this.assignDoctor({doctor_id:doctor._id,patient_id:this.patient._id})
    }
  }
  get filterdoctors() {
    const fo = new IgxFilterOptions();
    fo.key = "doctorname";

    fo.inputValue = this.searchdoctor;
    return fo;
  }
}
