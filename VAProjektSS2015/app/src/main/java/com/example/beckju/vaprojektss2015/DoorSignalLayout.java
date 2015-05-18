package com.example.beckju.vaprojektss2015;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

/**
 * Created by beckju on 15.05.15.
 */
public class DoorSignalLayout extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.doorsignallayout);

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
}