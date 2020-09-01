package com.f.healthmonitoring.awesomefirebase.fcm;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import android.util.Log;


import com.f.healthmonitoring.Activities.MainActivity;
import com.f.healthmonitoring.Activities.SplashActivity;
import com.f.healthmonitoring.R;
import com.f.healthmonitoring.awesomefirebase.fcm.events.PushNotificationEvent;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Random;

import androidx.core.app.NotificationCompat;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";
    private  static NotificationManager notificationManager1;
    private static final String ADMIN_CHANNEL_ID ="admin_channel";
    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */

    private static final String NOTIFICATION_Service_CHANNEL_ID = "10101";
    public static final String ACTION_STOP_FOREGROUND_SERVICE = "ACTION_STOP_FOREGROUND_SERVICE";
    public static final String ACTION_START_FOREGROUND_SERVICE = "ACTION_START_FOREGROUND_SERVICE";
    private NotificationManager mNotificationManager;
    private NotificationCompat.Builder mBuilder;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());

//        notificationManager =
//                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            setupChannels();
//        }
        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

            String title = remoteMessage.getData().get("title");
            String message = remoteMessage.getData().get("text");
            String username = remoteMessage.getData().get("username");
            String uid = remoteMessage.getData().get("uid");
            String fcmToken = remoteMessage.getData().get("fcm_token");
            String web = remoteMessage.getData().get("webphp");
            addPushNotification(title, message);


        }

    }


    /**
     * Create and show a simple notification containing the received FCM message.
     */


    private void addPushNotification(String title,
                                 String message) {
//
        Intent resultIntent = new Intent(getApplicationContext() , SplashActivity.class);

        resultIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);




        PendingIntent resultPendingIntent = PendingIntent.getActivity(getApplicationContext(),

                0 /* Request code */, resultIntent,

                PendingIntent.FLAG_ONE_SHOT);



        mBuilder = new NotificationCompat.Builder(getApplicationContext());

        mBuilder.setSmallIcon(R.drawable.logo);

        mBuilder.setContentTitle(title)

                .setContentText(message)

                .setAutoCancel(true)

                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)

                .setContentIntent(resultPendingIntent);



        mNotificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)

        {

            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_Service_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance);

            notificationChannel.enableLights(true);

            notificationChannel.setLightColor(Color.RED);

            notificationChannel.enableVibration(true);

            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});

            assert mNotificationManager != null;

            mBuilder.setChannelId(NOTIFICATION_Service_CHANNEL_ID);

            mNotificationManager.createNotificationChannel(notificationChannel);

        }
        int notificationId = new Random().nextInt(60000);


        mBuilder.build().flags |= Notification.FLAG_AUTO_CANCEL;

        assert mNotificationManager != null;
        mNotificationManager.notify(notificationId /* Request Code */, mBuilder.build());
        //startForeground(notificationId, mBuilder.build());
        //   startForeground(notificationId, mBuilder.build());
        stopForeground(true);
    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);

    }

}