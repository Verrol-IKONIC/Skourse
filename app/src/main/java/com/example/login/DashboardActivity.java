package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

 Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("App Start Activity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);

        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString(getResources().getString(R.string.prefLoginState),"loggedout");
                editor.apply();;
                startActivity(new Intent(DashboardActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}
