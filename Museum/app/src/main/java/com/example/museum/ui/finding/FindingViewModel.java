package com.example.museum.ui.finding;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FindingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FindingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("发现");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
