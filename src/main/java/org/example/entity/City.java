package org.example.entity;

public class City {

    private int id;
    private String countryCode;
    private String district;
    private String name;
    private int population;

    public City() {}

    public City(int id, String countryCode, String district, String name, int population) {
        this.id = id;
        this.countryCode = countryCode;
        this.district = district;
        this.name = name;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", countryCode='" + countryCode + '\'' +
                ", district='" + district + '\'' +
                ", name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}
