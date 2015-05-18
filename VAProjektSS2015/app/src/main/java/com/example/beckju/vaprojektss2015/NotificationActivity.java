package com.example.beckju.vaprojektss2015;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

/**
 * Created by beckju on 09.05.15.
 * there is notificationActivity.xml file 'cause clicking on the pending notification in
 * status Bar is supposed to open the app/ open the MainActivity
 */
public class NotificationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent openMainNoti = new Intent(this, MainActivity.class);

        int result = 1;

        startActivity(openMainNoti);

        setContentView(R.layout.activity_main);

    }

}
