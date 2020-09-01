import { Component, OnInit, Inject  } from '@angular/core';
import { IgxToastComponent, IgxListComponent, IgxFilterOptions } from 'igniteui-angular';
import { Router } from '@angular/router';
import { DOCUMENT } from '@angular/common';

@Component({
  selector: 'app-seeassignpatients',
  templateUrl: './seeassignpatients.component.html',
  styleUrls: ['./seeassignpatients.component.css']
})
export class SeeassignpatientsComponent implements OnInit {
  public searchpatient: string;
  public image="https://i.pinimg.com/originals/17/91/2d/17912d51f20769919ecce69a17db976f.png"
  public patients;
  public static clicked=false;

  public density = "comfortable";
  public displayDensities;
  


 constructor( private _router: Router, @Inject(DOCUMENT) private document: Document){
  this. patients=history.state.patients;

  if(this.patients==null){
    this._router.navigateByUrl('/doctorlist');

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

  
  public click(patient: any) {
    if(!SeeassignpatientsComponent.clicked)
        this._router.navigateByUrl('/showpatient',{state: {patient: patient.PatientData}});

  }
  get filterpatients() {
    const fo = new IgxFilterOptions();
    fo.key = "patientname";

    fo.inputValue = this.searchpatient;
    return fo;
  }

}
