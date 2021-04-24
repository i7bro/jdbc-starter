package org.example.dto;

public class CityFilter {

    private int limit;
    private String countryCode;
    private String district;

    public CityFilter(int limit, String countryCode, String district) {
        this.limit = limit;
        this.countryCode = countryCode;
        this.district = district;
    }

    public int getLimit() {
        return limit;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getDistrict() {
        return district;
    }
}
