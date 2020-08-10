import { Component, OnInit, Inject  } from '@angular/core';
import { IgxToastComponent, IgxListComponent, IgxFilterOptions } from 'igniteui-angular';
import {ApiService} from './api.service';
import { Router } from '@angular/router';
import { DOCUMENT } from '@angular/common';

@Component({
  selector: 'app-patientlist',
  templateUrl: './patientlist.component.html',
  styleUrls: ['./patientlist.component.css']
})
export class PatientlistComponent implements OnInit {
  public searchpatient: string;
  public image="https://i.pinimg.com/originals/17/91/2d/17912d51f20769919ecce69a17db976f.png"
  public patients;
  public static clicked=false;

  public density = "comfortable";
  public displayDensities;
  deletePatient(body) {

    this._apiService.deletePatient(body).subscribe(
       data => {
        console.log(data);
        this.document.location.reload();    
             PatientlistComponent.clicked=false

         // refresh the list
         return true;
       },
       error => {
        alert('Error!! :-)\n\n' +error)
        PatientlistComponent.clicked=false

         console.error(error);
         return false;
       }
    );
  }
  getPatients() {
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
this.getPatients()
if(localStorage.getItem('isloggedin')!="yes"){
  this._router.navigateByUrl('/login');

 }
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

  public toggleFavorite(patient: any) {
    PatientlistComponent.clicked=true
    //this._router.navigateByUrl('/patientlist');
    if(confirm("Are you sure to delete "+patient.patientname)) {
      this.deletePatient({patientId:patient._id})
    }else{
      PatientlistComponent.clicked=false

    }
  }
  public click(patient: any) {
    if(!PatientlistComponent.clicked)
        this._router.navigateByUrl('/showpatient',{state: {patient: patient}});

  }
  get filterpatients() {
    const fo = new IgxFilterOptions();
    fo.key = "patientname";

    fo.inputValue = this.searchpatient;
    return fo;
  }
}
