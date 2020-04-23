package com.example.covidtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DisplayNorthAmericaActivity extends AppCompatActivity {
    JSONObject obj;
    JSONArray countriesArray;
    int totalConfirmed = 0;
    int totalDeaths = 0;
    int totalRecovered = 0;
    public ArrayList<String> continentInfo = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north_america);

        // Load JSON object
        try {
            obj = new JSONObject(JSON.loadJSONFromFile(getAssets()));
            countriesArray = obj.getJSONArray("Countries");

            // Increment stats based on country of origin
            for (int i=0; i < countriesArray.length(); i++) {
                JSONObject countryDetail = countriesArray.getJSONObject(i);

                for (int j=0; j < Continents.northAmericaCountries.length; j++) {
                    if (countryDetail.getString("Country") == Continents.northAmericaCountries[j]) {
                        totalConfirmed += countryDetail.getInt("TotalConfirmed");
                        totalDeaths += countryDetail.getInt("TotalDeaths");
                        totalRecovered += countryDetail.getInt("TotalRecovered");
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Write data to String
        continentInfo.add("Continent: North America\n + " +
                         "Total Confirmed Cases: " + totalConfirmed + '\n' +
                         "Total Deaths: " + totalDeaths + '\n' +
                         "Total Recovered" + totalRecovered);

        // Display data in RecyclerView
        //mRecyclerView = findViewById(R.id.recyclerview);
        //mAdapter = new WordListAdapter(this, continentInfo);
        //mRecyclerView.setAdapter(mAdapter);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
