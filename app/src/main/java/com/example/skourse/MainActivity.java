package com.example.skourse;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.skourse.adapters.HorizontalCategoryAdapter;
import com.example.skourse.adapters.HorizontalCourseAdapter;
import com.example.skourse.adapters.VerticalSearchResultAdapter;

public class MainActivity extends AppCompatActivity {
    ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skourse__homepage);

        bar = getSupportActionBar();
        bar.hide();

        RecyclerView list_course = (RecyclerView) findViewById(R.id.RecyclerView_course);
        list_course.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        list_course.setAdapter(new HorizontalCourseAdapter(new String[]{"Alpro Course", "MobileApp Course", "Vocal Course"}));

        RecyclerView list_recently = (RecyclerView) findViewById(R.id.RecyclerView_recentlyBooked);
        list_recently.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        list_recently.setAdapter(new HorizontalCourseAdapter(new String[]{"MobileApp Course", "Vocal Course"}));

        RecyclerView list_category = (RecyclerView) findViewById(R.id.RecyclerView_category);
        list_category.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        list_category.setAdapter(new HorizontalCategoryAdapter(new String[]{"programming", "music", "art", "social", "programming", "music", "art", "social"}));
    }
}
