package com.example.darshaun.bac;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class splash extends AppCompatActivity {

    //private static int SPLASH_TIME_OUT = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Toast.makeText(this,"Click anywhere",Toast.LENGTH_LONG).show();

        RelativeLayout rlayout = (RelativeLayout) findViewById(R.id.splash);
        rlayout.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent i = new Intent(splash.this, first.class);
                startActivity(i);

                // close this activity
                finish();
            }
        });

        /*
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(splash.this, first.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
        */

    }
}
