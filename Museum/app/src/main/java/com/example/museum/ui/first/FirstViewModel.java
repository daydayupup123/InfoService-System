package com.example.museum.ui.first;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FirstViewModel extends  ViewModel{

        private MutableLiveData<String> mText;

        public FirstViewModel() {
            mText = new MutableLiveData<>();
            mText.setValue("精选");
        }

        public LiveData<String> getText() {
            return mText;
        }

}
