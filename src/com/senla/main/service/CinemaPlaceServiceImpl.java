package com.senla.main.service;


import com.senla.main.model.CinemaPlace;
import com.senla.main.repository.CinemaPlaceRepository;
import com.senla.main.repository.CinemaPlaceRepositoryImpl;

import java.util.ArrayList;

public class CinemaPlaceServiceImpl implements CinemaPlaceService {

    CinemaPlaceRepository cinemaPlaceRepository = new CinemaPlaceRepositoryImpl();

    @Override
    public ArrayList<CinemaPlace> getFreePlaces(int sessionId) {
        return cinemaPlaceRepository.getFreePlaces(sessionId);
    }
}
