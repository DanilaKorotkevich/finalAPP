package com.senla.main.service;

import com.senla.main.model.Session;
import com.senla.main.repository.FilmRepository;
import com.senla.main.repository.FilmRepositoryImpl;

import java.util.List;

public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository = new FilmRepositoryImpl();

    @Override
    public List<Session> getSessionList() {

        return filmRepository.getSessionList();
    }
}
