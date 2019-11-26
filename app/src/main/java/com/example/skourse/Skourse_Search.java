package com.example.skourse;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.skourse.ui.home.HomeFragment;
import com.example.skourse.ui.mycouse.MyCourseFragment;
import com.example.skourse.ui.profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class Skourse_Search extends AppCompatActivity {
    ActionBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skourse_search);

        bar = getSupportActionBar();
        bar.hide();

        HomeFragment fragmentHome = new HomeFragment();
        FragmentTransaction ftHome = getSupportFragmentManager().beginTransaction();
        ftHome.replace(R.id.nav_host_fragment, fragmentHome, "Home");
        ftHome.commit();

        BottomNavigationView navigation = findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_Home:
                        HomeFragment fragmentHome = new HomeFragment();
                        FragmentTransaction ftHome = getSupportFragmentManager().beginTransaction();
                        ftHome.replace(R.id.nav_host_fragment, fragmentHome, "Home");
                        ftHome.commit();
                        return true;
                    case R.id.navigation_myCourse:
                        MyCourseFragment fragmentCourse = new MyCourseFragment();
                        FragmentTransaction ftMycourse = getSupportFragmentManager().beginTransaction();
                        ftMycourse.replace(R.id.nav_host_fragment, fragmentCourse, "My Course");
                        ftMycourse.commit();
                        return true;
                    case R.id.navigation_Profile:
                        ProfileFragment fragmentProfile = new ProfileFragment();
                        FragmentTransaction ftProfile = getSupportFragmentManager().beginTransaction();
                        ftProfile.replace(R.id.nav_host_fragment, fragmentProfile, "Profile");
                        ftProfile.commit();
                        return true;
                }
                return false;
            }
        });
    }

}
