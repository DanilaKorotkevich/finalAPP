package com.senla.main.service;


import com.senla.main.model.Person;

public interface PersonService {

    Person create() throws ClassNotFoundException;

    Person authentication() throws ClassNotFoundException;
}
