package org.example.dao;

import org.example.ConnectionManager;
import org.example.entity.Country;
import org.example.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CountryDao implements Dao<String, Country> {

    private static final CountryDao INSTANCE = new CountryDao();
    private static final String FIND_ALL_SQL =
            "select code, capital, code2, continent, gnp, gnpold, governmentform, headOfState, indepYear" +
                    ", lifeExpectancy, localName, name, population, region, surfaceArea from country";
    private static final String FIND_ALL_BY_ID =
            FIND_ALL_SQL + " where code = ?";

    private CountryDao() {}

    public static CountryDao getInstance() {
        return INSTANCE;
    }

//    Так как при создании отдельной сущности требуется свое соединение,
//    теперь методы принимают соединения, а не создают
    public List<Country> findAll(Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(FIND_ALL_SQL)) {

            List<Country> list = new ArrayList<>();
            Country country = null;
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                country = buildCountry(resultSet);
                list.add(country);
            }

            return list;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Country> findAll() {
        try (Connection connection = ConnectionManager.get()) {

            return findAll(connection);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Country buildCountry(ResultSet resultSet) throws SQLException {
        return new Country(
                resultSet.getString("code"),
                resultSet.getObject("capital", Integer.class),
                resultSet.getString("code2"),
                resultSet.getString("continent"),
                resultSet.getObject("gnp", Float.class),
                resultSet.getObject("gnpold", Float.class),
                resultSet.getString("governmentForm"),
                resultSet.getObject("headOfState", String.class),
                resultSet.getObject("indepYear", Integer.class),
                resultSet.getObject("lifeExpectancy", Float.class),
                resultSet.getString("localName"),
                resultSet.getString("name"),
                resultSet.getInt("population"),
                resultSet.getString("region"),
                resultSet.getFloat("surfaceArea")
        );
    }

    public Optional<Country> findById(String id, Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_ID)) {

            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next() ? Optional.of(buildCountry(resultSet)) : Optional.empty();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<Country> findById(String id) {
        try (Connection connection = ConnectionManager.get()) {

            return findById(id, connection);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Country city) {

    }

    @Override
    public Country save(Country city) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
