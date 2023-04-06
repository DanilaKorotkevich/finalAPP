package com.senla.main.service;

import com.senla.main.model.Person;
import com.senla.main.repository.PersonRepository;
import com.senla.main.repository.PersonRepositoryImpl;
import com.senla.main.util.Print;

import java.util.Scanner;

public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository = new PersonRepositoryImpl();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Person create() {
        Print.ENTER_LOGIN();
        String username = scanner.nextLine();
        Print.ENTER_PASSWORD();
        String password = scanner.nextLine();

        Person person = new Person(username, password);
        Print.REG_COMPLETE();
        return person;
    }

    @Override
    public Person authentication() {
        Print.ENTER_LOGIN();
        String username = scanner.nextLine();
        Print.ENTER_PASSWORD();
        String password = scanner.nextLine();

        Person person = new Person(username, password);
        if (personRepository.check(person)) {
            return person;
        } else {
            Print.ENTRY_ERROR();
        }
        return null;
    }
}
