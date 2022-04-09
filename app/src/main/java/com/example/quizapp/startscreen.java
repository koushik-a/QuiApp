package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
// this is a starting screen splash activity
public class startscreen extends Activity{

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startingactivity);
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(startscreen.this,MainActivity.class);// intent to goto main activity
                startActivity(intent);
                finish();
            }
        },3000);// to wait this initial screen for 3 seconds

    }
}