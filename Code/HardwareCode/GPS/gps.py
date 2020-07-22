import serial
import time
import string
import pynmea2
from firebase import firebase
import datetime
from time import sleep

firebase = firebase.FirebaseApplication('https://healthmonitoring1200.firebaseio.com/', None)

while True:
    port="/dev/ttyAMA0"
    ser=serial.Serial(port, baudrate=9600, timeout=0.5)
    dataout = pynmea2.NMEAStreamReader()
    newdata=ser.readline()

    if newdata[0:6] == "$GPRMC":
        newmsg=pynmea2.parse(newdata)
        lat=newmsg.latitude
        lng=newmsg.longitude
        currentDT = datetime.datetime.now()
        data = {"Latitude": lat, "Longitude": lng,"time":currentDT.strftime("%Y-%m-%d %H:%M:%S")}
        firebase.post('/sensor/gps', data)
        gps = "Latitude=" + str(lat) + "and Longitude=" + str(lng)
        print(gps)
        sleep(15)
