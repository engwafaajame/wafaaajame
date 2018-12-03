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

import com.emuniapp.emuni.Fragment.HomeFragment;
import com.emuniapp.emuni.MainActivity;
import com.emuniapp.emuni.R;

import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplash extends AppCompatActivity {
    public static final int SPLASH_TIME = 3000;
    int count=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        final TextView counter = findViewById(R.id.timer);

   final Thread thread=new Thread()
   {
    @Override
       public  void run(){
        while (!isInterrupted()){
            try {
                Thread.sleep(1000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        count--;
                        counter.setText(String.valueOf(count));
                        if(count==1){
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }

                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }

      };
   thread.start();
        /*Intent intent = new Intent(getBaseContext(), SignUp.class);
        startActivity(intent);
        finish();*/


    }

}