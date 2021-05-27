package com.example.futtapp.Activity.ui.Basquet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BasquetViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BasquetViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}