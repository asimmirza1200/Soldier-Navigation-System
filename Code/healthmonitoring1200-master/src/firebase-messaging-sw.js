// Give the service worker access to Firebase Messaging.
// Note that you can only use Firebase Messaging here, other Firebase libraries
// are not available in the service worker.
importScripts('https://www.gstatic.com/firebasejs/7.15.3/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/7.15.3/firebase-messaging.js');

// Initialize the Firebase app in the service worker by passing in the
// messagingSenderId.
firebase.initializeApp({
  apiKey: "AIzaSyBkTUxwKcwexUu5Vt9o-qgorON7gq7lb9I",
  authDomain: "healthmonitoring1200.firebaseapp.com",
  databaseURL: "https://healthmonitoring1200.firebaseio.com",
  projectId: "healthmonitoring1200",
  storageBucket: "healthmonitoring1200.appspot.com",
  messagingSenderId: "399971213782",
  appId: "1:399971213782:web:6724afddfbc8ab31344477",
  measurementId: "G-66N2XELVZT"
});

// Retrieve an instance of Firebase Messaging so that it can handle background
// messages.
const messaging = firebase.messaging();
