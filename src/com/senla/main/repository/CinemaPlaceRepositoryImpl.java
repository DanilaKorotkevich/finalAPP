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
    Session session;
    @Override
    public ArrayList<CinemaPlace> getFreePlaces(int sessionId) {
        ArrayList<CinemaPlace> cinemaPlaces = new ArrayList<>();
        try(Connection connection = ConnectionManager.open()) {

            PreparedStatement statement = connection.prepareStatement("SELECT cp.id, cp.row, cp.place FROM cinema_place AS cp " +
                    "LEFT JOIN ticket AS t ON cp.id = t.id_cinema_place AND t.id_session = ? " +
                    "WHERE t.id_session IS NULL OR t.p_return = 1;");
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
