package com.emuniapp.emuni;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.emuniapp.emuni.Fragment.AboutFragment;
import com.emuniapp.emuni.Fragment.Addproduct;
import com.emuniapp.emuni.Fragment.FragmentUtils;
import com.emuniapp.emuni.Fragment.NewsFragment;
import com.emuniapp.emuni.Fragment.add_item;
import com.emuniapp.emuni.Fragment.viewcatogory;
import com.emuniapp.emuni.Fragment.viewitem;
import com.emuniapp.emuni.Fragment.viewnotificatition;
import com.facebook.FacebookSdk;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ConnectivityManager conMgr = (ConnectivityManager) getSystemService (Context.CONNECTIVITY_SERVICE);
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
            Fragment homeFragment =new add_item();
            FragmentUtils.addFragment(this,R.id.container,homeFragment,true);
            FragmentUtils.replaceFragment(this,R.id.container,homeFragment,true);


           DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_additem) {
            Fragment homeFragment =new add_item();
            FragmentUtils.replaceFragment(this,R.id.container,homeFragment,true);


            // Handle the camera action
        } else if (id == R.id.nav_addcatogory) {
            Fragment aboutFragment =new Addproduct();
            FragmentUtils.replaceFragment(this,R.id.container,aboutFragment,true);


        }

        else if (id == R.id.nav_additem) {
            Fragment aboutFragment =new add_item();
            FragmentUtils.replaceFragment(this,R.id.container,aboutFragment,true);


        }
        else if (id == R.id.nav_viewitem) {
            Fragment aboutFragment =new viewitem();
            FragmentUtils.replaceFragment(this,R.id.container,aboutFragment,true);


        }
        else if (id == R.id.nav_viewcatogory) {
            Fragment aboutFragment =new viewcatogory();
            FragmentUtils.replaceFragment(this,R.id.container,aboutFragment,true);


        }
        else if (id == R.id.navnotification) {
            Fragment aboutFragment =new viewnotificatition();
            FragmentUtils.replaceFragment(this,R.id.container,aboutFragment,true);


        }
        //navnotification

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
