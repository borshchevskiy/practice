package my.home.jdbc.dao;

import my.home.jdbc.entity.Flight;
import my.home.jdbc.exception.DaoException;
import my.home.jdbc.util.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Long, Flight> {
    public static final FlightDao INSTANCE = new FlightDao();

    public static final String FIND_BY_ID_SQL = """
            SELECT id,
            flight_no,
            departure_date,
            departure_airport_code,
            arrival_date,
            arrival_airport_code,
            aircraft_id,
            status
            FROM flight
            WHERE id = ?
            """;

    private FlightDao(){

    }

    public static FlightDao getInstance(){
        return  INSTANCE;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Flight save(Flight ticket) {
        return null;
    }

    @Override
    public void update(Flight ticket) {

    }

    @Override
    public Optional<Flight> findById(Long id) {
        try (var connection = ConnectionManager.get()) {
            return findById(id, connection);
        } catch (SQLException e) {
            throw  new DaoException(e);
        }
    }

    public Optional<Flight> findById(Long id, Connection connection){
        try (var prepareStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            prepareStatement.setLong(1,id);
            var resultSet = prepareStatement.executeQuery();
            Flight flight = null;
            if (resultSet.next()){
                flight = new Flight(resultSet.getLong("id"),
                        resultSet.getString("flight_no"),
                        resultSet.getTimestamp("departure_date").toLocalDateTime(),
                        resultSet.getString("departure_airport_code"),
                        resultSet.getTimestamp("arrival_date").toLocalDateTime(),
                        resultSet.getString("arrival_airport_code"),
                        resultSet.getInt("aircraft_id"),
                        resultSet.getString("status")
                );
            }
            return Optional.ofNullable(flight);
        } catch (SQLException e) {
            throw  new DaoException(e);
        }
    }

    @Override
    public List<Flight> findAll() {
        return null;
    }
}
