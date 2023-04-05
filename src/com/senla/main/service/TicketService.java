package com.senla.main.service;

import com.senla.main.model.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> getTickets(int id);

    boolean buyTicket(int personId, int sessionId, int cinemaPlaceId);

    void returnTicket(int id);
}
