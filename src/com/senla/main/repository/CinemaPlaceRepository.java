package com.senla.main.repository;

import com.senla.main.model.CinemaPlace;

import java.util.ArrayList;

public interface CinemaPlaceRepository {

    ArrayList<CinemaPlace> getFreePlaces(int sessionId);
}
