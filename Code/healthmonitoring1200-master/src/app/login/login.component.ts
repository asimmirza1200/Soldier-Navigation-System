import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {ApiService} from './api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  registerForm: FormGroup;
  submitted = false;

  constructor(private _apiService: ApiService, private _router: Router,private formBuilder: FormBuilder) { }

  ngOnInit() {
      this.registerForm = this.formBuilder.group({
          email: ['', [Validators.required, Validators.minLength(11)]],
          password: ['', [Validators.required, Validators.minLength(6)]],

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
      this.registerForm.value.token=localStorage.getItem('token')
     // alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.registerForm.value))
    this.loginAdmin(this.registerForm.value)
  }

  loginAdmin(body) {

    this._apiService.loginAdmin(body).subscribe(
       data => {
        console.log(data);
        localStorage.setItem('isloggedin', "yes");
        this._router.navigateByUrl('/dashboard');

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
