package com.example.covid19tracker.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Countries {
    @SerializedName("Country")
    @Expose
    String Country;
    @SerializedName("CountryCode")
    @Expose
    String CountryCode;
    @SerializedName("Slug")
    @Expose
    String Slug;
    @SerializedName("NewConfirmed")
    @Expose
    long NewConfirmed;
    @SerializedName("TotalConfirmed")
    @Expose
    long TotalConfirmed;
    @SerializedName("NewDeaths")
    @Expose
    long NewDeaths;
    @SerializedName("TotalDeaths")
    @Expose
    long TotalDeaths;
    @SerializedName("NewRecovered")
    @Expose
    long NewRecovered;
    @SerializedName("TotalRecovered")
    @Expose
    long TotalRecovered;
    @SerializedName("Date")
    @Expose
    String Date;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getSlug() {
        return Slug;
    }

    public void setSlug(String slug) {
        Slug = slug;
    }

    public String getNewConfirmed() {
        return String.valueOf(NewConfirmed);
    }

    public void setNewConfirmed(long newConfirmed) {
        NewConfirmed = newConfirmed;
    }

    public String getTotalConfirmed() {
        return String.valueOf(TotalConfirmed);
    }

    public void setTotalConfirmed(long totalConfirmed) {
        TotalConfirmed = totalConfirmed;
    }

    public String getNewDeaths() {
        return String.valueOf(NewDeaths);
    }

    public void setNewDeaths(long newDeaths) {
        NewDeaths = newDeaths;
    }

    public String getTotalDeaths() {
        return String.valueOf(TotalDeaths);
    }

    public void setTotalDeaths(long totalDeaths) {
        TotalDeaths = totalDeaths;
    }

    public String getNewRecovered() {
        return String.valueOf(NewRecovered);
    }

    public void setNewRecovered(long newRecovered) {
        NewRecovered = newRecovered;
    }

    public String getTotalRecovered() {
        return String.valueOf(TotalRecovered);
    }

    public void setTotalRecovered(long totalRecovered) {
        TotalRecovered = totalRecovered;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
    public String getUrlToImage()
    {
        return "https://www.countryflags.io/" + getCountryCode() +"/flat/64.png";
    }
}
