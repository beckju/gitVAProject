package com.example.beckju.vaprojektss2015;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.provider.MediaStore;
import android.support.v4.app.NotificationCompat;
import android.text.method.Touch;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

public class CommunicationLayout extends Activity {
    //--> no global variables in Java

    private boolean audioState = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.videocomlayout); //--> tell AS what Layout to use/ to call

        VideoView videotest = (VideoView) findViewById(R.id.videoviewcom);

        String videotestpath = "android.resource://" + getPackageName() + "/" + R.raw.vidsample;

        videotest.setVideoPath(videotestpath);

        videotest.start();


    }

 /*   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu_main);   // if additional menu needed, create menu-xml file for activity

        return true;
    }*/

    public void setAudioState(boolean set){

        audioState = set;
    }

    public boolean getAudioState(){

        return audioState;
    }

    public void GlobalAudio(int mode) {

        MediaPlayer audioTest = MediaPlayer.create(CommunicationLayout.this, R.raw.close); // declared fundtion to use as global --> no global in Java

        if (mode == 1) {
            if (audioTest.isPlaying()) {
                audioTest.seekTo(0);
            } else {
                audioTest.start();
            }
        }
        if (mode == 2)
            if (audioTest.isPlaying()) {
                audioTest.pause();
            } else {
                audioTest.pause();
                audioTest.stop();
            }
    }

    public void onClickOpenDoor(View view) {

        Intent confirmKeyword = new Intent(this, KeywordScreen.class);
        final int result = 1;
        startActivity(confirmKeyword);

    }

    public void onClickCancleCommunication(View view) {

        GlobalAudio(2);

        String CancleCommunicationInfo = "Connection was terminated";
        Toast.makeText(this, CancleCommunicationInfo, Toast.LENGTH_SHORT).show();

        finish();

        System.exit(0);
    }

    public void onClickplaySound(View view) {

        GlobalAudio(1);

    }

/*   public void AlertNotification (){

        System.out.println("Notification running");

    }*/

    public void AlertPopUp(String popUpMessage){

        new AlertDialog.Builder(CommunicationLayout.this)

                .setTitle("Smart Home - Alert")
                .setMessage(popUpMessage)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        //on click 'OK' main activity is started
                        Intent alertCallgoBackToMain = new Intent(CommunicationLayout.this, MainActivity.class);
                        final int result = 1;
                        startActivity(alertCallgoBackToMain);

                    }
                })

                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); //--> dialog dismissed active in status bar
                        System.out.println("Cancle button was clicked");

                   //     AlertNotification(); //--> kill dialog, create notification

                    }
                })

                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }

    public boolean MuteAudio(boolean audioMode){

        AudioManager mutecom = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);

        mutecom.setStreamMute(AudioManager.STREAM_MUSIC, audioMode);
        mutecom.setMicrophoneMute(audioMode);

        return true;
    }

    public void onClickMuteSound(View view) {

        if(getAudioState()){
            MuteAudio(false);
            setAudioState(false);

            String unmute = "Sound & micro activated";
            AlertPopUp(unmute);

        }

        else if(!getAudioState()) {
            MuteAudio(true);
            setAudioState(true);

            String mute = "App & micro muted!";
            AlertPopUp(mute);

        }

    }

}
