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

    public int getIdSession() {
        return idSession;
    }

    public void setIdSession(int idSession) {
        this.idSession = idSession;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return idSession +
                " Фильм " + film +
                " date " + date;
    }
}
