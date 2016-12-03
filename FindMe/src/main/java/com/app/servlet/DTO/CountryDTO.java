package com.app.servlet.DTO;

import java.util.ArrayList;

/**
 * Created by apavliuchenkova on 08/11/2016.
 */
public class CountryDTO implements Comparable<CountryDTO>{
    private int countryId;
    private String countryName;
    private ArrayList<CityDTO> cityList;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public ArrayList<CityDTO> getCityList() {
        return cityList;
    }

    public void setCityList(ArrayList<CityDTO> cityList) {
        this.cityList = cityList;
    }

    public int getCountryId() {return countryId; }

    public void setCountryId(int cityId) {this.countryId = cityId; }

    public CountryDTO(int countryId, String countryName, ArrayList<CityDTO> cityList) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.cityList = cityList;
    }

    @Override
    public int compareTo(CountryDTO o) {
        return this.countryName.compareToIgnoreCase(o.countryName);
    }
}
