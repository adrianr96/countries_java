package com.example.countries.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.countries.models.Country;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<Country>> countries;

    public void init(){

    }

    public LiveData<List<Country>> getCountries(){
        return countries;
    }
}
