import urllib2, urllib, httplib
import json
import os
from time import sleep
import datetime
from firebase import firebase
firebase = firebase.FirebaseApplication('https://healthmonitoring1200.firebaseio.com/', None)

f=open("guru99.txt")
BPM = f.readline()
f.close()
currentDT = datetime.datetime.now()
data = {"BPM": BPM,"Time":currentDT.strftime("%Y-%m-%d %H:%M:%S")}
firebase.post('/sensor/BMP', data)

