package com.example.beckju.vaprojektss2015;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by beckju on 15.05.15.
 *
 * Activity shown when door bell signal is received
 */

//um Gesten einzubauen (wischen nach rechts/links) "Gesture" suchen im Web
public class DoorSignalLayout extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.doorsignallayout);


        //Play test video in VideoView --> later camera
        VideoView videotest = (VideoView) findViewById(R.id.doorSignalVideoView);
        String videotestpath = "android.resource://" + getPackageName() + "/" + R.raw.vidsample;
        videotest.setVideoPath(videotestpath);
        videotest.start();

    }

    public void onClickAcceptSignal(View view) {

        Intent goToCom = new Intent(this, CommunicationLayout.class);

        final int result = 1;

        startActivity(goToCom);

    }

    public void onClickDeclineSignal(View view) {

        // needed to create/control notification

        NotificationManager myNotMng = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // prepare intent which is triggered if the
        // notification is selected

        Intent myNotiIntent = new Intent(this,NotificationActivity.class);

        /* A pending intent is a token that you give to another application,
        which allows this other application to use the permissions of your application to execute a predefined piece of code.*/

        PendingIntent myPenNotiIntent = PendingIntent.getActivity(this, 0, myNotiIntent, 0);

        // build notification

        NotificationCompat.Builder notiSmartHome = new NotificationCompat.Builder(this)
                .setContentTitle("SmartHome-Alert")
                .setContentText("Pending SmartHome protocol")
                .setSmallIcon(R.drawable.notiiconalert2)        //smallIcon = icon showed in status bar
                .setContentIntent(myPenNotiIntent);


        notiSmartHome.setContentIntent(myPenNotiIntent);
        notiSmartHome.setAutoCancel(true);
        notiSmartHome.setLights(Color.GREEN, 500, 500);         // set device LEDs when pending notification
        long[] pattern = {500,500,500,500,500,500,500,500,500}; //vibrate pattern
        notiSmartHome.setVibrate(pattern);                      //vibrate with defined pattern when notification is pending

        Uri myNotifSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        notiSmartHome.setSound(myNotifSound);

        myNotMng.notify(1,notiSmartHome.build());

        finish();

    }
}