package com.example.skourse;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ActionBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = getSupportActionBar();
        bar.hide();
        bar.setSubtitle("ini bercanda kan?!");

        Skourse_Profile skourse = new Skourse_Profile();
    }
    }
