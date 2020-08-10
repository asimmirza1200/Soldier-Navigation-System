import requests
from getmac import get_mac_address

f=open("guru99.txt")
BPM = f.readline()
url = 'https://healthmonitoring1200.herokuapp.com/sendAlertNotification'
eth_mac = get_mac_address()
myobj = {'deviceid': eth_mac}
if BPM=="0":
   x = requests.post(url, data = myobj)
   #print the response text (the content of the requested file):
   print(x.text)