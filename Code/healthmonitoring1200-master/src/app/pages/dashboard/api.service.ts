import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type':'application/x-www-form-urlencoded' })
};

@Injectable({
    providedIn: 'root'
  })
export class ApiService {

    constructor(private http:HttpClient) {
    }

    // NOTE: all API calls in this file use simple endpoints served by
    // an Express app in the file app.js in the repo root. See that file
    // for all back-end code.

    // Uses http.get() to load data from a single API endpoint
    getDashboardData() {
        return this.http.get('https://healthmonitoring1200.herokuapp.com/getDashboardData');
    }


}