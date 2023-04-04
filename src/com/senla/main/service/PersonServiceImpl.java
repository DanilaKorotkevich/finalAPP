package com.senla.main.service;

import com.senla.main.model.Person;
import com.senla.main.repository.PersonRepository;
import com.senla.main.repository.PersonRepositoryImpl;

import java.util.Scanner;

public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository = new PersonRepositoryImpl();

    @Override
    public Person create() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String username = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        Person person = new Person(username, password);
        System.out.println("Регистрация прошла успешно");
        return person;
    }

    @Override
    public Person authentication() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String username = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        Person person = new Person(username, password);
        if (personRepository.check(person)) {
            return person;
        }
        return null;
    }
}
