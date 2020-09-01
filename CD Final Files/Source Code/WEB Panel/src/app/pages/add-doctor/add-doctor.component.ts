import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {ApiService} from './api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})

export class AddDoctorComponent implements OnInit {
  registerForm: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder,private _apiService: ApiService, private _router: Router) { 
    if(localStorage.getItem('isloggedin')!="yes"){
      this._router.navigateByUrl('/login');
    
     }
  }

  ngOnInit() {
      this.registerForm = this.formBuilder.group({
          doctorname: ['', Validators.required],
          fathername: ['', Validators.required],
          phonenumber: ['', [Validators.required, Validators.minLength(11)]],
          password: ['', [Validators.required, Validators.minLength(6)]],
          address: ['', Validators.required],
          specialization: ['', Validators.required],
          qualification: ['', Validators.required],

      });
  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onSubmit() {
      this.submitted = true;

      // stop here if form is invalid
      if (this.registerForm.invalid) {
          return;
      }
     this.createDoctor(this.registerForm.value)
  }
  createDoctor(body) {
    this._apiService.createDoctor(body).subscribe(
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
}
