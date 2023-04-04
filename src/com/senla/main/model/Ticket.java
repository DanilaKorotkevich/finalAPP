package com.senla.main.model;

import java.util.Date;

public class Ticket {

    private int ticketId;
    private String filmName;
    private CinemaPlace cinemaPlace;
    private Date date;
    private boolean pReturn;

    public Ticket(int ticketId, String filmName, CinemaPlace cinemaPlace, boolean pReturn, Date date) {
        this.ticketId = ticketId;
        this.filmName = filmName;
        this.cinemaPlace = cinemaPlace;
        this.date = date;
        this.pReturn = pReturn;
    }

    @Override
    public String toString() {
        return  " Номер билета: " + ticketId + "\n" +
                " Фильм: " + filmName + "\n" + cinemaPlace + "\n" +
                " Дата: " + date;
    }
}
