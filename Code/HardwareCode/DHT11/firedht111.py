import RPi.GPIO as GPIO
from time import sleep
import datetime
from firebase import firebase
import Adafruit_DHT
import hashlib
from getmac import get_mac_address
import urllib2, urllib, httplib
import json
import os 
from functools import partial

GPIO.setmode(GPIO.BCM)
GPIO.cleanup()
GPIO.setwarnings(False)

# Sensor should be set to Adafruit_DHT.DHT11,
# Adafruit_DHT.DHT22, or Adafruit_DHT.AM2302.
sensor = Adafruit_DHT.DHT11

# Example using a Beaglebone Black with DHT sensor
# connected to pin P8_11.
pin = 4

# Try to grab a sensor reading.  Use the read_retry method which will retry up
# to 15 times to get a sensor reading (waiting 2 seconds between each retry).
humidity, temperature = Adafruit_DHT.read_retry(sensor, pin)


firebase = firebase.FirebaseApplication('https://healthmonitoring1200.firebaseio.com/', None)
#firebase.put("/dht", "/temp", "0.00")
#firebase.put("/dht", "/humidity", "0.00")

def update_firebase():
    
    humidity, temperature = Adafruit_DHT.read_retry(sensor, pin)
    if humidity is not None and temperature is not None:
        #sleep(1)
        str_temp = ' {0:0.2f} *C '.format(temperature)  
        str_hum  = ' {0:0.2f} %'.format(humidity)
        print('Temp={0:0.1f}*C  Humidity={1:0.1f}%'.format(temperature, humidity))
        currentDT = datetime.datetime.now()
        print (currentDT.strftime("%Y-%m-%d %H:%M:%S"))
            
    else:
        print('Failed to get reading. Try again!')  
        sleep(1)
    eth_mac = get_mac_address()
    result = hashlib.md5(str(temperature)+eth_mac[0:7])
    eth_mac_result = hashlib.md5(eth_mac)
    print(eth_mac)
    data = {"hash":result.hexdigest(),"temp": temperature, "humidity": humidity,"time":currentDT.strftime("%Y-%m-%d %H:%M:%S")}
    firebase.post(eth_mac_result.hexdigest()+'/sensor/dht', data)
    

while True:
        update_firebase()
        
        #sleepTime = int(sleepTime)
        sleep(5)

