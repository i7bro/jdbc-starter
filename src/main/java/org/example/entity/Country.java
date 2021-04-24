package org.example.entity;

public class Country {

    private String code;
    private Integer capital;
    private String code2;
    private String continent;
    private Float gpn;
    private Float gpnoLd;
    private String governmentForm;
    private String headIfState;
    private Integer indepYear;
    private Float lifeExpectancy;
    private String localName;
    private String name;
    private Integer population;
    private String region;
    private Float surfaceArea;

    public Country() {
    }

    public Country(
            String code, Integer capital, String code2,
            String continent, Float gpn, Float gpnoLd,
            String governmentForm, String headIfState,
            Integer indepYear, Float lifeExpectancy,
            String localName, String name, Integer population,
            String region, Float surfaceArea) {

        this.code = code;
        this.capital = capital;
        this.code2 = code2;
        this.continent = continent;
        this.gpn = gpn;
        this.gpnoLd = gpnoLd;
        this.governmentForm = governmentForm;
        this.headIfState = headIfState;
        this.indepYear = indepYear;
        this.lifeExpectancy = lifeExpectancy;
        this.localName = localName;
        this.name = name;
        this.population = population;
        this.region = region;
        this.surfaceArea = surfaceArea;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Float getGpn() {
        return gpn;
    }

    public void setGpn(Float gpn) {
        this.gpn = gpn;
    }

    public Float getGpnoLd() {
        return gpnoLd;
    }

    public void setGpnoLd(Float gpnoLd) {
        this.gpnoLd = gpnoLd;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadIfState() {
        return headIfState;
    }

    public void setHeadIfState(String headIfState) {
        this.headIfState = headIfState;
    }

    public Integer getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(Integer indepYear) {
        this.indepYear = indepYear;
    }

    public Float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(Float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", capital=" + capital +
                ", code2='" + code2 + '\'' +
                ", continent='" + continent + '\'' +
                ", gpn=" + gpn +
                ", gpnoLd=" + gpnoLd +
                ", governmentForm='" + governmentForm + '\'' +
                ", headIfState='" + headIfState + '\'' +
                ", indepYear=" + indepYear +
                ", lifeExpectancy=" + lifeExpectancy +
                ", localName='" + localName + '\'' +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", region='" + region + '\'' +
                ", surfaceArea=" + surfaceArea +
                '}';
    }
}
