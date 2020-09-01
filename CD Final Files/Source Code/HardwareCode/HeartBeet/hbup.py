import urllib2, urllib, httplib
import json
import os
import hashlib
from getmac import get_mac_address
from time import sleep
import datetime
from firebase import firebase
firebase = firebase.FirebaseApplication('https://healthmonitoring1200.firebaseio.com/', None)
f=open("guru99.txt")
BPM = f.readline()
eth_mac = get_mac_address()
result = hashlib.md5(BPM+eth_mac[0:7])
eth_mac_result = hashlib.md5(eth_mac)
print(eth_mac)
f.close()
currentDT = datetime.datetime.now()
data = {"hash":result.hexdigest(),"BPM": BPM,"Time":currentDT.strftime("%Y-%m-%d %H:%M:%S")}
firebase.post(eth_mac_result.hexdigest()+'/sensor/BMP', data)


