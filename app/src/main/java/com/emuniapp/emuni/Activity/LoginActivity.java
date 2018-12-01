package com.emuniapp.emuni.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.emuniapp.emuni.Interfaces.AppConstants;
import com.emuniapp.emuni.MainActivity;
import com.emuniapp.emuni.R;

public class LoginActivity extends AppCompatActivity {
    private long exitTime = 0;
    EditText username;
    EditText password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.email);
        password=findViewById(R.id.password);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        if (!((preferences.getString(AppConstants.username, "")).isEmpty() &&
                (preferences.getString(AppConstants.password, "")).isEmpty())) {
            username.setText(preferences.getString(AppConstants.password,""));
            password.setText(preferences.getString(AppConstants.password,""));
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();

                }

        login=findViewById(R.id.loginBtn);

    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (username.getText().toString().matches("")) {
                Toast.makeText(LoginActivity.this, "please enter your email", Toast.LENGTH_SHORT).show();
            } else if (password.getText().toString().matches("")) {
                Toast.makeText(LoginActivity.this, "please enter your password", Toast.LENGTH_SHORT).show();
            }
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(AppConstants.username,username.getText().toString());
                editor.putString(AppConstants.password,password.getText().toString());
                editor.apply();
                editor.commit();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();



        }
    });
    }


    @Override
    public void onBackPressed() {
        exitApp();
        super.onBackPressed();
    }

    private void exitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, getString(R.string.press_again_to_exit), Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }
}
