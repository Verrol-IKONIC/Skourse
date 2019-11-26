package com.example.skourse;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.skourse.adapters.HorizontalCourseAdapter;

public class MainActivity extends AppCompatActivity {
    ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skourse__homepage);

        bar = getSupportActionBar();
        bar.hide();

        RecyclerView list = (RecyclerView) findViewById(R.id.RecyclerView_course);
        list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        list.setAdapter(new HorizontalCourseAdapter(new String[]{"Alpro Course", "MobileApp Course", "Vocal Course"}));
    }
}
