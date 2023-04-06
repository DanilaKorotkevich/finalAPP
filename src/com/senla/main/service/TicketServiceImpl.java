package com.senla.main.service;

import com.senla.main.model.Ticket;
import com.senla.main.repository.TicketRepository;
import com.senla.main.repository.TicketRepositoryImpl;

import java.util.List;

public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository = new TicketRepositoryImpl();

    @Override
    public List<Ticket> getTickets(int id) {
        return ticketRepository.getTickets(id);
    }

    @Override
    public boolean buyTicket(int personId, int sessionId, int cinemaPlaceId) {
        return ticketRepository.buyTicket(personId, sessionId, cinemaPlaceId);
    }

    @Override
    public void returnTicket(int id) {
        ticketRepository.returnTicket(id);
    }
}
