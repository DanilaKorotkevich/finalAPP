package com.senla.main.repository;

import com.senla.main.model.CinemaPlace;
import com.senla.main.model.Ticket;
import com.senla.main.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketRepositoryImpl implements TicketRepository {

    @Override
    public List<Ticket> getTickets(int id) {
        List<Ticket> tickets = new ArrayList<>();
        try(Connection connection = ConnectionManager.open()) {

            PreparedStatement statement = connection.prepareStatement("SELECT t.id AS id_ticket, f.name, cp.row, cp.place, l.date, cp.id " +
                    "FROM ticket AS t, cinema_place AS cp, film AS f, session_list AS l " +
                    "WHERE t.id_person = ? AND t.p_return = 0 AND t.id_session = l.id AND t.id_cinema_place = cp.id AND l.id_film = f.id;");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int ticketId = resultSet.getInt("id_ticket");
                String filmName = resultSet.getString("name");
                int row = resultSet.getInt("row");
                int place = resultSet.getInt("place");
                int cinemaPlaceId = resultSet.getInt("id");
                Date date = resultSet.getDate("date");
                Ticket ticket = new Ticket(ticketId, filmName, new CinemaPlace(cinemaPlaceId, row, place), false, date);
                tickets.add(ticket);
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return tickets;
    }

    @Override
    public boolean buyTicket(int personId, int sessionId, int cinemaPlaceId) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement =
                    connection.prepareStatement("INSERT INTO ticket (id_person, id_session, id_cinema_place, p_return) VALUES (?,?,?,0)");
            statement.setString(1, String.valueOf(personId));
            statement.setString(2, String.valueOf(sessionId));
            statement.setString(3, String.valueOf(cinemaPlaceId));
            statement.execute();
            System.out.println("Билет успешно приобретен");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
