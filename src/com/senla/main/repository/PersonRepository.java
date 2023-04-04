package com.senla.main.repository;

import com.senla.main.model.Person;

import java.util.List;

public interface PersonRepository {

    boolean create(Person person) throws ClassNotFoundException;

    List<Person> getAllPersons();

    Person getPerson(Integer id);

    Person update(Person person, Integer id);

    boolean check(Person person);

}
