package com.senla.main.model;

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
