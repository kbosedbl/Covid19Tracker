package com.example.covid19tracker.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result1 {
    @SerializedName("Global")
    @Expose
    Global global;
    @SerializedName("Countries")
    @Expose
    List<Countries> countries;

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

    public List<Countries> getCountries() {
        return countries;
    }

    public void setCountries(List<Countries> countries) {
        this.countries = countries;
    }
}
