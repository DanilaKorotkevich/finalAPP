package com.senla.main.repository;


import com.senla.main.model.Film;
import com.senla.main.model.Session;
import com.senla.main.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmRepositoryImpl implements FilmRepository {


    @Override
    public List<Session> getSessionList() {
        List<Session> sessions = new ArrayList<>();
        try(Connection connection = ConnectionManager.open()) {

            PreparedStatement statement = connection.prepareStatement("SELECT f.id, f.name, l.date, l.id as id_session FROM session_list as l, film as f WHERE l.id_film = f.id AND l.date > CURRENT_DATE()");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id_session = resultSet.getInt("id_session");
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Timestamp date = resultSet.getTimestamp("date");
                Session session = new Session (id_session, new Film(id, name), date);
                sessions.add(session);
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return sessions;
    }
}
