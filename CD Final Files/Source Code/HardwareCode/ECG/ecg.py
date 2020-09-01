import serial
import time
import datetime
import hashlib
from getmac import get_mac_address
from firebase import firebase
firebase = firebase.FirebaseApplication('https://healthmonitoring1200.firebaseio.com/', None)
ser = serial.Serial('/dev/ttyUSB0',9600)
s = [0]
count=0
ecg=""
while True:
    count+=1
    read_serial=ser.readline()
    #s[0] = str(float (ser.readline()))
    #print s[0]
    print read_serial
    ecg+=","+read_serial.strip()
    
    if count==15 :
        eth_mac = get_mac_address()
        result = hashlib.md5(str(ecg)+eth_mac[0:7])
        eth_mac_result = hashlib.md5(eth_mac)
        print(eth_mac)
        currentDT = datetime.datetime.now()
        
        print(ecg)
        data = {"hash":result.hexdigest(),"ecg": ecg,"time":currentDT.strftime("%Y-%m-%d %H:%M:%S")}
        firebase.post(eth_mac_result.hexdigest()+'/sensor/ecg', data)
        count=0
        ecg=""
