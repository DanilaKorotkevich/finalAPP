package com.senla.main.util;

import com.senla.main.controller.PersonController;

public class Menu {

    public static void start() {
        PersonController personController = new PersonController();
        try {
            personController.startMenu();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
