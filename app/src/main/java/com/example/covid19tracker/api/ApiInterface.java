package com.example.covid19tracker.api;

import com.example.covid19tracker.models.Countries;
import com.example.covid19tracker.models.Result1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("summary")
    Call<Result1> getInformation();
}
