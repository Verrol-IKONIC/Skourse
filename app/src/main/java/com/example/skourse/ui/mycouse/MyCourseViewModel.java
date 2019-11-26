package com.example.skourse.ui.mycouse;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyCourseViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyCourseViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}