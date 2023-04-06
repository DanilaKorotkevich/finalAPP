package com.senla.main.model;

import java.util.Date;

public class Session {

    private int idSession;
    private Film film;
    private Date date;

    public Session(int idSession, Film film, Date date) {
        this.idSession = idSession;
        this.film = film;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Идентификатор сеанса " + idSession +
                " Фильм " + film +
                " date " + date;
    }
}
