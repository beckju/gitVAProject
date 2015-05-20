package com.example.beckju.vaprojektss2015;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by beckju on 25.03.15.
 *
 * Für eingehendes Brief-Signal --> Pop-Up und beim Wegklicken Notification
 */
//wasd

public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            new AlertDialog.Builder(MainActivity.this)

                    .setTitle("Smart Home - Alert")
                    .setMessage("Settings")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {

                            Intent alertCallMain = new Intent(MainActivity.this, MainActivity.class);
                            final int result = 1;
                            startActivity(alertCallMain);

                        }
                    })

                    .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })

                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();


            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onClickHelpMain(View view) {

        String helpResponse = "Click either Accept to build an audio communikation or click Decline to end the communication request";

        Toast.makeText(this, helpResponse,Toast.LENGTH_LONG).show();

    }

    public void onClickDoorSignal(MenuItem item) {

        Intent goToDoorLayout = new Intent(this,DoorSignalLayout.class);

        final int result = 1;

        startActivity(goToDoorLayout);
    }

    public void onClickImageViewMain(View view) {

        Intent goToComLayout = new Intent(this, CommunicationLayout.class);

        final int result = 1;

        startActivity(goToComLayout);
    }

    public void onClickCameraMain(View view) {

        Intent setupCommunication = new Intent(this,CommunicationLayout.class );

        final int result = 1;

        //setupCommunication.putExtra("setupActivity", "MainActivity"); --> just needed if you want to send data to the second screen

        startActivity(setupCommunication); //--> if other activity doesn't send back data
    }

    public void onClickNewUserMain(View view) {

        Intent createNewUser = new Intent(this,NewUserLayout.class);

        final int result = 1;

        startActivity(createNewUser);
    }

    public void onClickTcpConnection(MenuItem item) {

        Intent mTCP = new Intent(this, TcpSignal.class);

        final int result = 1;

        startActivity(mTCP);

    }
}
