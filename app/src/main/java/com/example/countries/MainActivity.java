package com.example.countries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.countries.adapters.CountryAdapter;
import com.example.countries.models.Country;
import com.example.countries.viewmodels.MainActivityViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CountryAdapter adapter;
    private ArrayList<Country> countries = new ArrayList<>();
    private EditText editText;
    private MainActivityViewModel mainActivityViewModel;

    private String editTextString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.et_country_query);
        recyclerView = (RecyclerView) findViewById(R.id.rv_countries);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                editTextString = editText.getText().toString();
                setRetrofit();
            }
        });

        setRetrofit();
        setRecyclerView();
    }

    private void setRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/rest/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CountryWebService countryWebService = retrofit.create(CountryWebService.class);

        Call<ArrayList<Country>> call = countryWebService.getCountries(editTextString);

        call.enqueue(new Callback<ArrayList<Country>>() {
            @Override
            public void onResponse(Call<ArrayList<Country>> call, Response<ArrayList<Country>> response) {
                countries = response.body();
                adapter = new CountryAdapter(countries, recyclerView);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Country>> call, Throwable t) {

            }
        });
    }

    private void setRecyclerView(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new CountryAdapter(countries, recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
