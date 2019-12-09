package com.example.skourse.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.skourse.R;
import com.example.skourse.Skourse_Search;
import com.example.skourse.adapters.HorizontalCategoryAdapter;
import com.example.skourse.adapters.HorizontalCourseAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {
    Button btn_searchs;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btn_searchs = view.findViewById(R.id.button_search);
        btn_searchs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test();
            }
        });

        RecyclerView list_course = view.findViewById(R.id.RecyclerView_course);
        list_course.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        list_course.setAdapter(new HorizontalCourseAdapter(new String[]{"Alpro Course", "MobileApp Course", "Vocal Course"}));

        RecyclerView list_recently = view.findViewById(R.id.RecyclerView_recentlyBooked);
        list_recently.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        list_recently.setAdapter(new HorizontalCourseAdapter(new String[]{"MobileApp Course", "Vocal Course"}));

        RecyclerView list_category = view.findViewById(R.id.RecyclerView_category);
        list_category.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        list_category.setAdapter(new HorizontalCategoryAdapter(new String[]{"programming", "music", "art", "social", "programming", "music", "art", "social"}));

        return view;
    }

    public void test(){
        Intent intent = new Intent(getActivity(), Skourse_Search.class);
        startActivity(intent);
        getActivity().finish();
    }
}