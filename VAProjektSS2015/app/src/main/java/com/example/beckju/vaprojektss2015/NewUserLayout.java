package com.example.beckju.vaprojektss2015;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class NewUserLayout extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.newuserlayout);

    }

    public void onClickNewUserEnter(View view) {

        Intent newUserEntergoBackToMain = new Intent(this,MainActivity.class);

        int result = 1;

        startActivity(newUserEntergoBackToMain);

        String userCreated = "New user was created";

        Toast.makeText(this,userCreated,Toast.LENGTH_SHORT).show();

    }

    public void onClickNewUserCancle(View view) {

        Intent newUserCanclegoBackToMain = new Intent(this,MainActivity.class);

        int result = 1;

        startActivity(newUserCanclegoBackToMain);

    }
}
