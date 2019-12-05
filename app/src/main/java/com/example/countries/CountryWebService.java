package com.example.countries;

import com.example.countries.models.Country;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CountryWebService {

    @GET("name/{name}")
    Call<ArrayList<Country>> getCountries(@Path("name") String name);

}
