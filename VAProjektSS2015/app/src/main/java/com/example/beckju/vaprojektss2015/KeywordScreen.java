package com.example.beckju.vaprojektss2015;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class KeywordScreen extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.keyword_layout);
    }

    public void onClickKeywordConfirm(View view) {

        EditText getKeyword = (EditText) findViewById(R.id.editTextEnterKeyword);

        String doorwarning = "Attention! The front door was opened!";

        Toast.makeText(this, doorwarning, Toast.LENGTH_LONG).show();

        Intent goBacktoMain = new Intent(this, MainActivity.class);

        final int result = 1;

        startActivity(goBacktoMain);

    }

    public void onClickKeywordCancle(View view) {

        Intent keywordScreenGoBacktoMain = new Intent(this,MainActivity.class);

        final int result = 1;

        startActivity(keywordScreenGoBacktoMain);
    }
}
