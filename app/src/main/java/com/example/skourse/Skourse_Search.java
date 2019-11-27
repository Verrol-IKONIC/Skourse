package com.example.skourse;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Skourse_Search extends AppCompatActivity {
    ActionBar bar;
    ImageButton back;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skourse_search);
        bar =getSupportActionBar();
        bar.hide();

        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            backtoMain();
        }
    });

    }

    public void backtoMain(){
        Intent intent = new Intent(this, Skourse_Main.class);
        startActivity(intent);
    }

}
