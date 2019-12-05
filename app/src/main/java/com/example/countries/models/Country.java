package com.example.countries.models;

import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("name")
    private String country;

    private String capital;

    public Country(String country, String capital) {
        this.country = country;
        this.capital = capital;
    }

    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }

}
