import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'nav-main',
  templateUrl: './nav-main.component.html',
  styleUrls: ['./nav-main.component.css']
})
export class NavMainComponent {
  public href: string = "";

  logout(){
    localStorage.removeItem('isloggedin')
    this.router.navigateByUrl('/login');

  }
    constructor(private router: Router) {}

    ngOnInit() {
        this.href = window.location.toString().split("/")[window.location.toString().split("/").length-1];
        if(this.href=="doctorlist"){
          this.href="Doctors";
        }
        else  if(this.href=="patientlist"){
          this.href="Patients";
        }
        else  if(this.href=="about"){
          this.href="About";
        }
        else  if(this.href=="dashboard"){
          this.href="Dashboard";
        }

      }

}
