package com.senla.main.service;

import com.senla.main.model.CinemaPlace;

import java.util.ArrayList;

public interface CinemaPlaceService {

    ArrayList<CinemaPlace> getFreePlaces(int sessionId);
}
