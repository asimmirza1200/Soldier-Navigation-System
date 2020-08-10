import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
    headers: new HttpHeaders({'Content-Type':'application/x-www-form-urlencoded'})
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
    getPatients() {
        return this.http.get('https://healthmonitoring1200.herokuapp.com/getAllPatient');
    }

   
    // Uses Observable.forkJoin() to run multiple concurrent http.get() requests.
    // The entire operation will result in an error state if any single request fails.
    // getBooksAndMovies() {
    //     return Observable.forkJoin(
    //     this.http.get('/api/books'),
    //     this.http.get('/api/movies')
    //     );
    // }

    // send a POST request to the API to create a new data object
    createPatient(food) {
        let body = JSON.stringify(food);
        return this.http.post('https://healthmonitoring1200.herokuapp.com/insertPatient', body, httpOptions);
    }

    // send a PUT request to the API to update a data object
    updatePatient(food) {
        let body = JSON.stringify(food);
        return this.http.put('/api/food/' + food.id, body, httpOptions);
    }

    // send a DELETE request to the API to delete a data object
    deletePatient(food) {
        return this.http.delete('/api/food/' + food.id);
    }

}