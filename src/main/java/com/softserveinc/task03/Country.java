package com.softserveinc.task03;

import com.softserveinc.task02.City;

import java.util.Arrays;

public class Country {
    private String name;
    private String continent;
    private String code;
    private City capital;
    private City[] cities;

    public Country() {
        this(null, null, null, null);
    }

    public Country(String name, String continent, String code, City capital) {
        this.name = name;
        this.continent = continent;
        this.code = code;
        this.capital = capital;
        this.cities = new City[]{capital};
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    public void addCity(City city) {
        cities = Arrays.copyOf(cities, cities.length + 1);
        cities[cities.length - 1] = city;
    }

    public int getInhabitants() {
        int count = 0;

        if(cities == null) {
            return count;
        }

        for(City c: cities) {
            count += c.getInhabitants();
        }

        return count;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", code='" + code + '\'' +
                ", capital=" + capital +
                ", cities=" + Arrays.toString(cities) +
                '}';
    }
}
