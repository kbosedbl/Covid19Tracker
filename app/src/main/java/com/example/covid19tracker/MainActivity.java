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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        loadJSON();
    }
    public void loadJSON()
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
                    for(int i = 99 ; i < 200 ; i++)
                    {
                        dummycountries.add(countries.get(i+2));
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
