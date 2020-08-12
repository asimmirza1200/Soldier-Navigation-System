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

   
    loginAdmin(admin) {
        let body = JSON.stringify(admin);
        return this.http.post('https://healthmonitoring1200.herokuapp.com/loginAdmin', body, httpOptions);
    }

}