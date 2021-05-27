package com.example.futtapp.Activity.ui.Futbol;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FutbolViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FutbolViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}