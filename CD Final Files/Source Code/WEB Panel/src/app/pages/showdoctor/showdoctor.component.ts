import { Component, OnInit, ViewChild } from '@angular/core';
import { ChartDataSets, ChartOptions } from 'chart.js';
import { Color, Label,BaseChartDirective } from 'ng2-charts';
import { Router } from '@angular/router';
import { ApiService } from './api.service';
@Component({
  selector: 'app-showdoctor',
  templateUrl: './showdoctor.component.html',
  styleUrls: ['./showdoctor.component.css']
})
export class ShowdoctorComponent implements OnInit {
  doctor:any;
  totalpatients: number;
  assignpatients: any;
  doctors: any;
  ngOnInit(): void {
  

  }
  public toggleFavorite() {
    // alert('Error!! :-)\n\n' )
      if(confirm("Are you sure to delete "+this.doctor.doctorname)) {
        this.deleteDoctor({doctorId:this.doctor._id})
      }
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
  deleteDoctor(body) {

    this._apiService.deleteDoctor(body).subscribe(
       data => {
        console.log(data);
           this._router.navigateByUrl('/doctorlist');

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
  getAssignPatient(body) {

    this._apiService.getAssignPatient(body).subscribe(
       data => {
        console.log(data);
         this. totalpatients=data.result.length>0?data.result.length:0
         this. assignpatients=data.result

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
  public selectPatient() {
    this._router.navigateByUrl('/assignpatient',{state: {doctor: this.doctor}});

  }
  public seeAssignPatients() {
    this._router.navigateByUrl('/seeassignpatients',{state: {patients: this.assignpatients}});

  }
  constructor( private _router: Router,private _apiService: ApiService){
    if(localStorage.getItem('isloggedin')!="yes"){
      this._router.navigateByUrl('/login');
    
     }
    this. doctor=history.state.doctor;
    if(this.doctor==null){
      this._router.navigateByUrl('/doctorlist');

    }else{
      this.getAssignPatient({doctor_id:this.doctor._id})

    }
    
    console.log(this.doctor)
  }
  
}