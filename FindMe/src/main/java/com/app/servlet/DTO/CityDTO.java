package com.app.servlet.DTO;

/**
 * Created by apavliuchenkova on 08/11/2016.
 */
public class CityDTO implements Comparable<CityDTO>{

    private int cityId;
    private String cityName;

    public CityDTO(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public String getCityName() {

        return cityName;
    }

    public void setCityName(String cityName) {

        this.cityName = cityName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public int compareTo(CityDTO o) {
        return this.cityName.compareToIgnoreCase(o.cityName);
    }
}
