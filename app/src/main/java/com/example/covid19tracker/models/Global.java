package com.example.covid19tracker.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Global {
    @SerializedName("NewConfirmed")
    @Expose
    String NewConfirmed;
    @SerializedName("TotalConfirmed")
    @Expose
    String TotalConfirmed;
    @SerializedName("NewDeaths")
    @Expose
    String NewDeaths;
    @SerializedName("TotalDeaths")
    @Expose
    String TotalDeaths;
    @SerializedName("NewRecovered")
    @Expose
    String NewRecovered;
    @SerializedName("TotalRecovered")
    @Expose
    String TotalRecovered;

    public String getNewConfirmed() {
        return NewConfirmed;
    }

    public void setNewConfirmed(String newConfirmed) {
        NewConfirmed = newConfirmed;
    }

    public String getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setTotalConfirmed(String totalConfirmed) {
        TotalConfirmed = totalConfirmed;
    }

    public String getNewDeaths() {
        return NewDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        NewDeaths = newDeaths;
    }

    public String getTotalDeaths() {
        return TotalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        TotalDeaths = totalDeaths;
    }

    public String getNewRecovered() {
        return NewRecovered;
    }

    public void setNewRecovered(String newRecovered) {
        NewRecovered = newRecovered;
    }

    public String getTotalRecovered() {
        return TotalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        TotalRecovered = totalRecovered;
    }
}
