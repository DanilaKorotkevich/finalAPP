package com.senla.main.model;

public class CinemaPlace {

    int id;
    int row;
    int place;

    public CinemaPlace(int id, int row, int place) {
        this.id = id;
        this.row = row;
        this.place = place;
    }

    @Override
    public String toString() {
        return "идентификатор места: " + id + " Ряд: " + row +
                " Место: " + place;
    }
}
