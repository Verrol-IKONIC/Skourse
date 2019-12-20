package com.example.skourse;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    ActionBar bar;
    private int waktu_loading = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent home = new Intent(MainActivity.this, Skourse_Profile.class);
                startActivity(home);
                finish();

//                Skourse_MainProfile skourse_mainProfile = new Skourse_MainProfile();
//                FragmentTransaction ftHome = getSupportFragmentManager().beginTransaction();
//                ftHome.replace(R.id.activity_main, skourse_mainProfile, "Home");
//                ftHome.commit();

            }
        }, waktu_loading);
    }
}

