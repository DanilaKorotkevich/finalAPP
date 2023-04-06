package com.senla.main.util;

public class Print {

    public static final void HELLO () {
        System.out.print("Добро пожаловать\n");
    }

    public static final void START_MENU () {
        System.out.print("""
                1 -> Зарегистрироваться
                2 -> Войти в аккаунт
                0 -> Закрыть приложение
                """);
    }

    public static void FIRST_MENU() {
        System.out.println("""
            
            Рады видеть вас в нашем кинотеатре, введите число нужного вам меню
            
            1 -> Список сеансов
            2 -> Купить билет
            3 -> Просмотреть купленные билеты
            0 -> Выйти с аккаунта
            """);
    }

    public static final void REG_MENU() {
        System.out.println("РЕГИСТРАЦИЯ/REGISTRATION");
    }

    public static final void ENTRY_MENU() {
        System.out.println("ВОЙТИ/SIGN IN");
    }

    public static final void EXIT() {
        System.out.println("Спасибо, что посетили наш кинотеатр");
    }

    public static final void WAIT_MESS() {
        System.out.println("Вы ввели некоректные данные, повторите ввод:\n");
    }

    public static final void BACK() {
        System.out.println("Введите '0', чтобы вернуться назад");
    }

    public static final void BUY_MENU() {
        System.out.println("Меню покупка билетов");
    }

    public static final void AVAILABLE_SESSION() {
        System.out.println("Доступные сеансы\n");
    }

    public static final void CHOSE_SESSION_ID() {
        System.out.println("Укажите идентификатор сеанса: ");
    }

    public static final void CHOSE_PLACE_ID() {
        System.out.println("Укажите идентификатор места: ");
    }

    public static final void SESSION_MENU() {
        System.out.println("Меню сеансы");
    }

    public static final void BUY_TICKET_MENU() {
        System.out.println("Меню купленные билеты\n");
    }

    public static final void RETURN_TICKET() {
        System.out.println("Введите '2', если хотите вернуть билет");
    }

    public static final void ENTER_RETURNED_TICKET() {
        System.out.println("укажите номер билета который хотите вернуть: ");
    }

    public static final void ENTER_LOGIN() {
        System.out.printf("Введите логин: ");
    }

    public static final void ENTER_PASSWORD() {
        System.out.printf("Введите пароль: ");
    }

    public static final void REG_COMPLETE() {
        System.out.println("Регистрация прошла успешно");
    }

    public static final void ENTRY_ERROR() {
        System.out.println("Ошибка входа, проверьте логин или пароль");
    }

    public static final void PRINT_GET_TICKET_COMPLETE() {
        System.out.println("Билет успешно приобретен");
    }

    public static final void PRINT_RETURN_TICKET_COMPLETE() {
        System.out.println("Билет успешно возвращен");
    }
}
