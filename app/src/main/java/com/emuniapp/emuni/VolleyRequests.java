package com.emuniapp.emuni;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * Created by hp on 12/09/2017.
 */

public class VolleyRequests<T> extends Observable {
    interface IReceiveData<T> {
        void onDataReceived(T posts);
    }

    IReceiveData iReceiveData;

    public void RegisterUser(String Firstname, String Lastname , String Email, String Phonenumber, String Password , String RPassword ) {
        StringRequest jsonObjectRequestregister = new StringRequest(Request.Method.POST, "http://shawarmahouse.online/register_android.php?fname=" + Firstname + "&lname=" + Lastname + "&email=" +Email + "&phone=" +Phonenumber + "&password=" +Password+ "&repassword=" +RPassword, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                JsonResult jsonResult = gson.fromJson(response.toString(), JsonResult.class);

                setChanged();
                notifyObservers(jsonResult);

                if (iReceiveData != null) {
                    iReceiveData.onDataReceived(jsonResult);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MyApplication.getInstance().addToRequestQueue(jsonObjectRequestregister);
    }

    public void logout(String email){
        StringRequest jsonObjectRequestLogout=new StringRequest(Request.Method.POST, "http://shawarmahouse.online/logout_android.php?email="+email+"", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                JsonResult jsonResult = gson.fromJson(response.toString(), JsonResult.class);

                setChanged();
                notifyObservers(jsonResult);

                if (iReceiveData != null) {
                    iReceiveData.onDataReceived(jsonResult);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MyApplication.getInstance().addToRequestQueue(jsonObjectRequestLogout);
    }




    public void getToken(final String token, final String email, final String password) {
        StringRequest jsonObjectRequest = new StringRequest(Request.Method.POST,
                "http://shawarmahouse.online/fcm_insert.php?token="+token+"&email="+email+"&password="+password,    new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                JsonResult jsonResult = gson.fromJson(response.toString(), JsonResult.class);

                setChanged();
                notifyObservers(jsonResult);

                if (iReceiveData != null) {
                    iReceiveData.onDataReceived(jsonResult);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
           /*   {
          @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
            Map<String,String> map = new HashMap();
                map.put("token",token);
                map.put("email",email);
                map.put("password",password);
                return map;
            }
        };*/

        MyApplication.getInstance().addToRequestQueue(jsonObjectRequest);
    }

    public void login(final String username, final String password) {
        StringRequest jsonObjectRequest = new StringRequest(Request.Method.POST,
                "http://shawarmahouse.online/login.php",  new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                JsonResult jsonResult = gson.fromJson(response.toString(), JsonResult.class);

                setChanged();
                notifyObservers(jsonResult);

                if (iReceiveData != null) {
                    iReceiveData.onDataReceived(jsonResult);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap();
                map.put("email",username);
                map.put("password",password);
                return map;
            }
        };

        MyApplication.getInstance().addToRequestQueue(jsonObjectRequest);
    }

    public VolleyRequests setIReceiveData(IReceiveData iReceiveData) {
        this.iReceiveData = iReceiveData;
        return this;
    }
}