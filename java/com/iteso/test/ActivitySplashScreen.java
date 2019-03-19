package com.iteso.test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Boolean.FALSE;


public class ActivitySplashScreen extends AppCompatActivity {

    public static final int DELAY_SPLASH = 1000;

    SharedPreferences sharedPreferences;

    public User loadPreferences(){
        sharedPreferences= this.getSharedPreferences("com.iteso.test.tarea4", Context.MODE_PRIVATE);
        User user = new User();
        user.setUsername(sharedPreferences.getString("USER",null));
        user.setPassword(sharedPreferences.getString("PWD",null));
        user.setLogged(sharedPreferences.getBoolean("isLogged",false));
        sharedPreferences=null;
        return user;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                User user = loadPreferences();
                Intent intent;
                if(user.getLogged()){
                    intent = new Intent().setClass(ActivitySplashScreen.this,ActivityMain.class);
                } else {
                    intent = new Intent().setClass(ActivitySplashScreen.this,ActivityLogin.class);
                }
                startActivity(intent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask,DELAY_SPLASH);
    }



}
