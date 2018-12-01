package com.emuniapp.emuni.Activity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.emuniapp.emuni.MainActivity;
import com.emuniapp.emuni.R;

import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplash extends AppCompatActivity {
    private ProgressBar progressBar;
    public static final int SPLASH_TIME = 3000;
    int count=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        final TextView textView=findViewById(R.id.timer);
        Timer T=new Timer();
        T.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
               // textView.setText("count="+count);
               // count--;
            }
        }, 1000, 1000);



        new CountDownTimer(SPLASH_TIME, 1000) {

            @Override
            public void onFinish() {

                Intent intent = new Intent(getBaseContext(), SignUp.class);
                startActivity(intent);
                finish();
                progressBar.setVisibility(View.GONE);



            }

            @Override
            public void onTick(long millisUntilFinished) {

            }
        }.start();

    }







    @Override
    public void onBackPressed()
    {

        super.onBackPressed();
    }
}
