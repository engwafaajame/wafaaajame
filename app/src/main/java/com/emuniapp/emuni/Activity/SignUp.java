package com.emuniapp.emuni.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.emuniapp.emuni.Config;
import com.emuniapp.emuni.Interfaces.AppConstants;
import com.emuniapp.emuni.MainActivity;
import com.emuniapp.emuni.Models.Category;
import com.emuniapp.emuni.Models.CategoryResponse;
import com.emuniapp.emuni.Models.Student;
import com.emuniapp.emuni.Models.StudentResponse;
import com.emuniapp.emuni.MyApplication;
import com.emuniapp.emuni.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

public class SignUp extends AppCompatActivity {
EditText id, Name;
Button singup,loaddata,registerdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        id=(EditText)findViewById(R.id.id);
        Name=(EditText)findViewById(R.id.name);
        singup=(Button)findViewById(R.id.singup);
        loaddata=(Button)findViewById(R.id.loaddata);
        registerdata=(Button)findViewById(R.id.registerdata);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        if (!((preferences.getString(AppConstants.username, "")).isEmpty() &&
                (preferences.getString(AppConstants.password, "")).isEmpty())) {
            id.setText(preferences.getString("id",""));
            Name.setText(preferences.getString("Name",""));
            Intent intent = new Intent(SignUp.this,MainActivity.class);
            startActivity(intent);
            finish();

        }


        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Name.getText().toString().matches("")) {
                    Toast.makeText(SignUp.this, "please enter your email", Toast.LENGTH_SHORT).show();
                } else if (id.getText().toString().matches("")) {
                    Toast.makeText(SignUp.this, "please enter your password", Toast.LENGTH_SHORT).show();
                }
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SignUp.this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("id",id.getText().toString());
                editor.putString("Name",Name.getText().toString());
                editor.apply();
                editor.commit();
                Intent intent = new Intent(SignUp.this,MainActivity.class);
                startActivity(intent);
                finish();



            }
        });


    }


    public void getCategory(final String student_id, String student_name){
        StringRequest jsonArrayRequest = new StringRequest(Request.Method.POST,"http://wasfat.club/api/add_student.php?student_id="+student_id + "&student_name="+student_name,new Response.Listener<String>() {

                @Override
            public void onResponse(String response) {

                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                StudentResponse studentResponse=gson.fromJson(response.toString(),StudentResponse.class);

                id.setText(((StudentResponse)studentResponse).getstudents().get(0).getId());

                Name.setText(((StudentResponse)studentResponse).getstudents().get(0).getName());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        MyApplication.getInstance().addToRequestQueue(jsonArrayRequest);
    }




}
