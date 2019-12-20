package com.example.skourse.ui.mycouse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.skourse.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MyCourseFragment extends Fragment {

    private MyCourseViewModel myCourseViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myCourseViewModel = ViewModelProviders.of(this).get(MyCourseViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mycourse, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        myCourseViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}