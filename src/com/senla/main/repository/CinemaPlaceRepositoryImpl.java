package com.senla.main.repository;

import com.senla.main.model.CinemaPlace;
import com.senla.main.model.Session;
import com.senla.main.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CinemaPlaceRepositoryImpl implements CinemaPlaceRepository {
    @Override
    public ArrayList<CinemaPlace> getFreePlaces(int sessionId) {
        ArrayList<CinemaPlace> cinemaPlaces = new ArrayList<>();
        try(Connection connection = ConnectionManager.open()) {

            PreparedStatement statement = connection.prepareStatement("SELECT cp.id, cp.row, cp.place FROM cinema_place AS cp LEFT JOIN ticket AS t ON cp.id = t.id_cinema_place AND t.id_session = ? WHERE t.id_session IS NULL OR t.p_return = 1 AND NOT EXISTS(SELECT 1 FROM ticket AS t1 WHERE t1.id_session = t.id_session AND t1.p_return = 0 AND t1.id_cinema_place = t.id_cinema_place) GROUP BY cp.id, cp.row, cp.place;");
            statement.setInt(1, sessionId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int CinemaPlaceId = resultSet.getInt("id");
                int row = resultSet.getInt("row");
                int place = resultSet.getInt("place");
                CinemaPlace cinemaPlace = new CinemaPlace(CinemaPlaceId, row, place);
                cinemaPlaces.add(cinemaPlace);
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return cinemaPlaces;
    }
}
