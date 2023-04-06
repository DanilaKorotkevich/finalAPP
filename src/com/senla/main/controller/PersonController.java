package com.senla.main.controller;

import com.senla.main.model.CinemaPlace;
import com.senla.main.model.Person;
import com.senla.main.service.*;
import com.senla.main.util.Print;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonController {

    private Person person;
    private PersonService personService = new PersonServiceImpl();
    private FilmService filmService = new FilmServiceImpl();
    private TicketService ticketService = new TicketServiceImpl();
    private final Scanner scanner = new Scanner(System.in);
    private CinemaPlaceService cinemaPlaceService = new CinemaPlaceServiceImpl();

    private final int ONE = 1;
    private final int TWO = 2;
    private final int THREE = 3;
    private final int ZERO = 0;

    public void startMenu() throws ClassNotFoundException {

        int step1 = -1;
        Print.HELLO();
        while (step1 != ZERO) {

            Print.START_MENU();
            try {
                step1 = scanner.nextInt();
                step1 = firstStep(step1);

                if (person != null) {
                    Print.FIRST_MENU();
                    int step2 = scanner.nextInt();
                    secondStep(step2);
                }
            } catch (RuntimeException e) {
                scanner.nextLine();
                Print.WAIT_MESS();

            }
        }
    }

    private int firstStep(int step1) throws ClassNotFoundException {

            switch (step1) {

                case ONE:
                    Print.REG_MENU();
                    person = personService.create();
                    break;

                case TWO:
                    Print.ENTRY_MENU();
                    person = personService.authentication();
                    break;

                case ZERO: {
                    Print.EXIT();
                    System.exit(0);
                    break;
                }

                default:
                    Print.WAIT_MESS();
            }
            return step1;
    }

    private void secondStep(int step2) throws ClassNotFoundException {

        switch (step2) {

            case ONE :
                showSessions();
                break;

            case TWO :
                buyTicket();
                break;

            case THREE :
                checkBoughtTickets();
                break;

            case ZERO :
                startMenu();
                break;

            default:
                Print.WAIT_MESS();

        }
    }

    private void buyTicket() throws ClassNotFoundException {

        Print.BUY_MENU();
        Print.AVAILABLE_SESSION();

                filmService.getSessionList().forEach(System.out::println);
                Print.CHOSE_SESSION_ID();
                int sessionId = scanner.nextInt();
                ArrayList<CinemaPlace> freePlacesArr = cinemaPlaceService.getFreePlaces(sessionId);
                freePlacesArr.forEach(System.out::println);

                Print.CHOSE_PLACE_ID();
                int cinemaPlace = scanner.nextInt();
                ticketService.buyTicket(person.getId(), sessionId, cinemaPlace);

                Print.BACK();
                int backStep = scanner.nextInt();
                    if (backStep == ZERO) {
                        Print.FIRST_MENU();
                        int step2 = scanner.nextInt();
                        secondStep(step2);
                    }
    }

    private void showSessions() throws ClassNotFoundException {

        Print.SESSION_MENU();
        Print.AVAILABLE_SESSION();
        filmService.getSessionList().forEach(System.out::println);
        Print.BACK();
        int backStep = scanner.nextInt();

        if (backStep == ZERO) {
            Print.FIRST_MENU();
            int step2 = scanner.nextInt();
            secondStep(step2);
        }
    }

    private void checkBoughtTickets() throws ClassNotFoundException {

        int chose = 0;
        boolean isExist = true;
        Print.BUY_TICKET_MENU();
        ticketService.getTickets(person.getId()).forEach(System.out::println);
        
        while (isExist) {
            Print.RETURN_TICKET();
            Print.BACK();
            chose = scanner.nextInt();
            if (chose == ZERO) {
                Print.FIRST_MENU();
                int step2 = scanner.nextInt();
                secondStep(step2);
            }
            else if (chose == TWO)
                returnTicket();
                ticketService.getTickets(person.getId()).forEach(System.out::println);
        }
    }

    private void returnTicket() {
        Print.ENTER_RETURNED_TICKET();
        int ticket = scanner.nextInt();
        ticketService.returnTicket(ticket);

    }

}
