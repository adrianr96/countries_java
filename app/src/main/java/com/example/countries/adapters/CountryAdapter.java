package com.example.countries.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countries.models.Country;
import com.example.countries.R;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter {

    private String TAG = "CountryAdapter.class";
    private ArrayList<Country> countries = new ArrayList<>();
    private RecyclerView recyclerView;
    private Context context;

    private class ViewHolder extends RecyclerView.ViewHolder {
        public TextView country;
        public TextView capital;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            country = (TextView) itemView.findViewById(R.id.tv_country);
            capital = (TextView) itemView.findViewById(R.id.tv_capital);
        }
    }

    public CountryAdapter(ArrayList<Country> articles, RecyclerView recyclerView) {
        this.countries= articles;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "Kliknięto");
            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Country country = countries.get(position);
        ((ViewHolder) holder).country.setText(country.getCountry());
        ((ViewHolder) holder).capital.setText(country.getCapital());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }
}
