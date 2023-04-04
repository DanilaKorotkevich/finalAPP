package com.senla.main.repository;

import com.senla.main.model.Ticket;

import java.util.List;

public interface TicketRepository {

    List<Ticket> getTickets(int id);

    boolean buyTicket(int personId, int sessionId, int cinemaPlaceId);
}
