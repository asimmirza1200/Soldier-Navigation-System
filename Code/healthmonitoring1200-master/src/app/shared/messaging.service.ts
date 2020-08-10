import { Injectable } from '@angular/core';
import { AngularFireMessaging } from '@angular/fire/messaging';
import { BehaviorSubject } from 'rxjs'
import { ToastrService } from 'ngx-toastr';

@Injectable({
    providedIn: 'root'
  })
  export class MessagingService {
 
currentMessage = new BehaviorSubject(null);
 
constructor(private toastrService: ToastrService,private angularFireMessaging: AngularFireMessaging) {

//      this.angularFireMessaging.messaging.subscribe(
//      (msgings) => {
//    msgings.onMessage = msgings.onMessage.bind(msgings);
//    msgings.onTokenRefresh=msgings.onTokenRefresh.bind(msgings);
//     })
  }
 
  requestPermission() {
    this.angularFireMessaging.requestToken.subscribe(
    (token) => {
      localStorage.setItem('token',token)

    console.log(token);
    });
  }
 
  receiveMessage() {
    this.angularFireMessaging.messages.subscribe(
    (msg) => {
    console.log("show message!", msg);
    //this.toastrService.error("Doctor I am in critical situation please Contact with mee", msg.notification.title)
    //this.showNotification('bottom', 'right')
    alert("Doctor "+msg.notification.title+" is in critical situation please contact with him");
    this.currentMessage.next(msg);
       
    })

    showNotification(from, align){

      const color =2;

      switch(color){
        case 2:
        this.toastrService.success('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span> Welcome to <b>Black Dashboard Angular</b> - a beautiful freebie for every web developer.', '', {
           disableTimeOut: false,
           closeButton: true,
           enableHtml: true,
           toastClass: "alert alert-success alert-with-icon",
           positionClass: 'toast-' + from + '-' +  align
         });
        break;
      
        default:
        break;
      }
  }
}
