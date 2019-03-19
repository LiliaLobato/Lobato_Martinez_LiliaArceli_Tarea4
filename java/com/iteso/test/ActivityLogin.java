package com.iteso.test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityLogin extends AppCompatActivity {

    public EditText username;
    public EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.activity_login_username);
        password = (EditText) findViewById(R.id.activity_login_password);
    }

    public void login(View v) {

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.iteso.test.tarea4", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("USER",username.getText().toString());
        editor.putString("PSW",password.getText().toString());
        editor.putBoolean("PSW",true);
        editor.apply();
        Intent intent;
        intent = new Intent().setClass(this,ActivityMain.class);
        startActivity(intent);
    }



}
