package com.senla.main.util;

public class Print {

    public static final void HELLO () {
        System.out.print("Добро пожаловать\n");
    }

    public static final void START_MENU () {
        System.out.print("""
                1 -> Зарегестрироваться
                2 -> Войти в аккаунт
                0 -> Закрыть приложение
                """);
    }

    public static void FIRST_MENU() {
        System.out.println("""
            Выберите операцию:
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
        System.out.println("Вы ввели некоректные данные, повторите ввод:");
    }

    public static final void BACK() {
        System.out.println("Введите '0', чтобы вернуться назад");
    }

    public static final void SIGN_OUT() {
        System.out.println("Введите '1', чтобы вернуться назад");
    }

    public static final void BUY() {
        System.out.println("Введите '2', чтобы купить билет");
    }
}
