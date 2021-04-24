package org.example;

import org.example.dao.CityDao;
import org.example.dao.CountryDao;
import org.example.dto.CityFilter;
import org.example.entity.City;
import org.example.entity.Country;

import java.sql.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException {
        System.out.println(CityDao.getInstance().findById(1));
    }

    private static void findAllCountry() {
        CountryDao countryDao = CountryDao.getInstance();
        List<Country> all = countryDao.findAll();
        System.out.println(all.size());
    }

    private static void findAllByFilter() {
        CityDao cityDao = CityDao.getInstance();
        List<City> all = cityDao.findAll(new CityFilter(10, "RUS", "Udmurtia"));
        System.out.println(all);
    }

    private static void findAll() {
        List<City> cities = CityDao.getInstance().findAll();
        System.out.println(cities);
    }

    private static void updateTest() {
        CityDao cityDao = CityDao.getInstance();
        Optional<City> mbyCity = cityDao.findById(4081);
        mbyCity.ifPresent(x -> {
            x.setDistrict("Udmurtiya");
            x.setName("Izh");
            x.setPopulation(200000000);
            cityDao.update(x);
        });
    }

    private static void deleteTest() {
        CityDao cityDao = CityDao.getInstance();
        System.out.println(cityDao.delete(4080));
    }

    private static void saveTest() {
        CityDao cityDao = CityDao.getInstance();
        City cityIzh = new City(4080, CountryDao.getInstance().findById("RUS").orElse(null), "Udmurtiya", "NewIzhevsk", 700_000);

        City save = cityDao.save(cityIzh);
        System.out.println(Objects.nonNull(save));
    }
}
