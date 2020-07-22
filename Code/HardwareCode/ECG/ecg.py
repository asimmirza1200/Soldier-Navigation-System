import serial
import time
import datetime
from firebase import firebase
firebase = firebase.FirebaseApplication('https://healthmonitoring1200.firebaseio.com/', None)
ser = serial.Serial('/dev/ttyUSB0',9600)
s = [0]
while True:
	read_serial=ser.readline()
	#s[0] = str(float (ser.readline()))
	#print s[0]
	print read_serial
        currentDT = datetime.datetime.now()
        data = {"ecg": read_serial,"time":currentDT.strftime("%Y-%m-%d %H:%M:%S")}
        firebase.post('/sensor/ecg', data)
        #time.sleep(1)