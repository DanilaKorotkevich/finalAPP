package com.senla.main.model;

import java.sql.Timestamp;

public class Film {

    private int id;
    private String name;

    public Film(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
