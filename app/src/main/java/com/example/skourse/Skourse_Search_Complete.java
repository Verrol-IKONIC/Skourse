package com.example.skourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Skourse_Search_Complete extends AppCompatActivity {
    TextView tampilsearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skourse_search_complete);

        tampilsearch = findViewById(R.id.textView3);

        Intent i = getIntent();
        String search = i.getStringExtra("search");

        tampilsearch.setText(search);
    }
}
