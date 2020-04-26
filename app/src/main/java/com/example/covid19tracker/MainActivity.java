package com.example.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.covid19tracker.api.ApiClient;
import com.example.covid19tracker.api.ApiInterface;
import com.example.covid19tracker.models.Adapter;
import com.example.covid19tracker.models.Countries;
import com.example.covid19tracker.models.Result1;
import com.scrounger.countrycurrencypicker.library.Buttons.CountryCurrencyButton;
import com.scrounger.countrycurrencypicker.library.Country;
import com.scrounger.countrycurrencypicker.library.Currency;
import com.scrounger.countrycurrencypicker.library.Listener.CountryCurrencyPickerListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<Countries> countries = new ArrayList<>();
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Adapter adapter;
    private CountryCurrencyButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
        button = (CountryCurrencyButton) findViewById(R.id.button);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        button.setShowCurrency(false);
        loadJSON("India");
        button.setOnClickListener(new CountryCurrencyPickerListener() {
            @Override
            public void onSelectCountry(Country country) {
                if (country.getCurrency() == null) {
                    /*Toast.makeText(MainActivity.this,
                            String.format("name: %s\ncode: %s", country.getName(), country.getCode())
                            , Toast.LENGTH_SHORT).show();*/
                    loadJSON(country.getName());
                } else {
                    Toast.makeText(MainActivity.this,
                            String.format("name: %s\ncurrencySymbol: %s", country.getName(), country.getCurrency().getSymbol())
                            , Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onSelectCurrency(Currency currency) {

            }
        });
    }
    public void loadJSON(final String string)
    {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Result1> call;
        call = apiInterface.getInformation();
        call.enqueue(new Callback<Result1>() {
            @Override
            public void onResponse(Call<Result1> call, Response<Result1> response) {
                if(response.isSuccessful() && response.body().getCountries() != null)
                {
                    //Toast.makeText(MainActivity.this,String.valueOf(response.body().getCountries().size()),Toast.LENGTH_SHORT).show();
                    countries.clear();
                    countries = response.body().getCountries();
                    //Toast.makeText(MainActivity.this,String.valueOf(countries.get(0).getCountry()),Toast.LENGTH_SHORT).show();
                    List<Countries> dummycountries = new ArrayList<>();
                    for(int i = 0 ; i < countries.size() ; i++)
                    {
                        if(string.equals(countries.get(i).getCountry()))
                        dummycountries.add(countries.get(i));
                    }
                    adapter = new Adapter(dummycountries , MainActivity.this);
                    recyclerView.setAdapter(adapter);
                }
                else{
                    Toast.makeText(MainActivity.this,"Unable to load",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Result1> call, Throwable t) {

            }
        });
    }
}
