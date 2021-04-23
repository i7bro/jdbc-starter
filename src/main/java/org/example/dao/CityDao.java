package org.example.dao;

import com.sun.scenario.effect.impl.prism.PrReflectionPeer;
import org.example.ConnectionManager;
import org.example.entity.City;
import org.example.exception.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityDao {

    private static final CityDao INSTANCE = new CityDao();
    private static final String DELETE_SQL = "delete from city where id = ?;";
    private static final String SAVE_SQL =
            "insert into city (id, countryCode, district, name, population) " +
                    "values (?, ?, ?, ?, ?);";
    private static final String UPDATE_SQL = "update city set " +
            "countryCode = ?, district = ?, name = ?, population = ? where id = ?;";
    private static final String FIND_ALL_SQL =
            "select id, countryCode, district, name, population from city";
    private static final String FIND_BY_ID_SQL = FIND_ALL_SQL +
                    " where id = ?";

    public CityDao() {
    }

    public List<City> findAll() {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            List<City> cities = new ArrayList<>();
            while (resultSet.next()) {
                cities.add(buildCity(resultSet));
            }

            return cities;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public Optional<City> findById(int id) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            City city = null;
            if (resultSet.next()) {
                city = buildCity(resultSet);
            }

            return Optional.ofNullable(city);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private City buildCity(ResultSet resultSet) throws SQLException {
        return new City(
                resultSet.getInt("id"),
                resultSet.getString("countryCode"),
                resultSet.getString("district"),
                resultSet.getString("name"),
                resultSet.getInt("population")
        );
    }

    public void update(City city) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {

            preparedStatement.setInt(1, city.getId());
            preparedStatement.setString(1, city.getCountryCode());
            preparedStatement.setString(2, city.getDistrict());
            preparedStatement.setString(3, city.getName());
            preparedStatement.setInt(4, city.getPopulation());
            preparedStatement.setInt(5, city.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public City save(City city) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL)) {

            preparedStatement.setInt(1, city.getId());
            preparedStatement.setString(2, city.getCountryCode());
            preparedStatement.setString(3, city.getDistrict());
            preparedStatement.setString(4, city.getName());
            preparedStatement.setInt(5, city.getPopulation());

            preparedStatement.executeUpdate();
            return city;
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    public boolean delete(int id) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement ps = connection.prepareStatement(DELETE_SQL)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static CityDao getInstance() {
        return INSTANCE;
    }
}
