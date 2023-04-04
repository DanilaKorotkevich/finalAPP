package com.senla.main.controller;

import com.senla.main.model.CinemaPlace;
import com.senla.main.model.Person;
import com.senla.main.model.Session;
import com.senla.main.service.*;
import com.senla.main.util.Print;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonController {

    private Person person;
    private Session session;
    private PersonService personService = new PersonServiceImpl();
    private FilmService filmService = new FilmServiceImpl();
    private TicketService ticketService = new TicketServiceImpl();
    private final Scanner scanner = new Scanner(System.in);
    private CinemaPlaceService cinemaPlaceService = new CinemaPlaceServiceImpl();

    private final String ONE = "1";
    private final String TWO = "2";
    private final String THREE = "3";
    private final String ZERO = "0";

    public void startMenu() throws ClassNotFoundException {

        boolean isExist;
        Print.HELLO();
        do {
            Print.START_MENU();
            String step1 = scanner.nextLine();
            isExist = firstStep(step1);
        } while (isExist);
        isExist = true;
        while (isExist == true) {
            if (person != null) {
                Print.FIRST_MENU();
                String step2 = scanner.nextLine();
                isExist = secondStep(step2);
            }

        }
    }

    private boolean firstStep(String step1) throws ClassNotFoundException {
        boolean isExist = true;

            switch (step1) {
                case ONE:
                    Print.REG_MENU();
                    person = personService.create();
                    isExist = false;
                    break;
                case TWO:
                    Print.ENTRY_MENU();
                    person = personService.authentication();
                    isExist = false;
                    break;

                case ZERO: {
                    Print.EXIT();
                }
                default:
                    Print.WAIT_MESS();
            }
            return isExist;
    }

    private boolean secondStep(String step2) throws ClassNotFoundException {
        boolean isExist = true;

        switch (step2) {
            case ONE :
                isExist = showSessions();
                break;
            case TWO :
                buyTicket();
                break;
            case THREE :
                isExist = checkBoughtTickets();
                break;
            case ZERO :
                Print.SIGN_OUT();
                startMenu();
                break;
            default:
                Print.WAIT_MESS();
        }

        return isExist;
    }

    private void buyTicket() {
        boolean isExist = true;

        System.out.println("Меню покупка билетов\n");
            System.out.println("доступные сеансы");

            while (isExist) {
                filmService.getSessionList().forEach(System.out::println);
                System.out.println("Выберите сеанс: ");
                int sessionId = scanner.nextInt();
                ArrayList<CinemaPlace> freePlacesArr = cinemaPlaceService.getFreePlaces(sessionId);
                freePlacesArr.forEach(System.out::println);
                System.out.println("Укажите идентификатор места: ");
                try {
                    int cinemaPlace = scanner.nextInt();
                    ticketService.buyTicket(person.getId(), sessionId, cinemaPlace);

                    System.out.println("нажмите '0', чтобы вернуться назад");
                    int backStep = scanner.nextInt();
                    if (backStep == 0) {
                        isExist = false;
                    }
                } catch (RuntimeException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
    }

    private boolean showSessions() {
        boolean isExist = true;

        System.out.println("меню сеансы");
        System.out.println("доступные сеансы");
        filmService.getSessionList().forEach(System.out::println);
        Print.BACK();
        String backStep = scanner.nextLine();

        if (backStep == ZERO) {
            isExist = false;
        }

        return isExist;
    }

    private boolean checkBoughtTickets() {
        boolean isExist = true;

        System.out.println("меню купленные билеты:\n");
        ticketService.getTickets(person.getId()).forEach(System.out::println);
        Print.BACK();
        String backStep = scanner.nextLine();

        if (backStep == ZERO) {
            isExist = false;
        }

        return isExist;
    }

}
