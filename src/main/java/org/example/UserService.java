package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService {
    List<User> userList;
    Scanner csr = new Scanner(System.in);


    public void Menu(){
        UserService userService = new UserService();
        while (true) {
            System.out.println();
            System.out.println("Выберите, что вы хотите сделать?");
            System.out.println("Добавить пользователя - [1]");
            System.out.println("Удалить пользователя - [2]");
            System.out.println("вывести всех пользователей, баланс которых выше 1000 - [3]");
            System.out.println("Найти пользователя по id - [4]");
            System.out.println("Удалить всех пользователей - [5]");
            int console = csr.nextInt();

            if (console == 1) {
                userService.UserAdd();
            } else if (console == 2) {
                userService.UserDelete();
            } else if (console == 3) {
                userService.UserBalanse();
            } else if (console == 4) {
                userService.UserId();
            } else if (console == 5) {
                userService.Userliste();
            } else {
                System.err.println("Такого варианта нет, попробуйте еще раз! ");
            }
        }


    }

    public UserService() {
        userList = new ArrayList<>();
        User user1 = new User(LocalDate.of(2000, 2, 20), "alex_brown", "aBr0wn!23", 1, 2000F);
        User user2 = new User(LocalDate.of(1990, 1, 11), "sophia_smith ", "Soph$99sm", 2, 12000F);
        User user3 = new User(LocalDate.of(1992, 3, 17), "john_doe", "jd_321P@ss ", 3, 1000.00F);
        User user4 = new User(LocalDate.of(1993, 7, 1), "emily_jones ", "EmilYJ$94", 4, 54.04F);
        User user5 = new User(LocalDate.of(1988, 4, 18), "michael_clark", "Mclark!88 ", 5, 550.28F);
        User user6 = new User(LocalDate.of(1995, 9, 19), "lily_wilson ", "lilw99son", 6, 753.89F);
        User user7 = new User(LocalDate.of(2000, 5, 7), "daniel_evans ", "D@nEvAns2000 ", 7, 1200.08F);
        User user8 = new User(LocalDate.of(1999, 12, 29), "olivia_martin", "Ol!Viam8", 8, 649.0F);
        User user9 = new User(LocalDate.of(1987, 9, 22), "jack_taylor ", "J@ckT1987", 9, 15000.45F);
        User user10 = new User(LocalDate.of(1991, 6, 5), "ava_white ", "Avaw@h10!", 10, 34000.30F);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user7);
        userList.add(user8);
        userList.add(user9);
        userList.add(user10);


    }




    public boolean UserAdd() { //добавить пользователя в список
        System.out.println("Добавить пользователя: ");// Сделать в меню по типу 1- добавить 2 - и т.д

        System.out.println("Введите год :");
        int year = csr.nextInt();

        int month;
        while (true) {
            System.out.println("Введите месяц: ");
            month = csr.nextInt();
            if (month > 12 || month < 1) {
                System.err.println("Неправильный формат месяца! Попробуйте еще раз.");
                // csr.nextInt();
            } else {
                break;
            }
        }

        int day;
        while (true) {

            System.out.println("Введите день рождения: ");
            day = csr.nextInt();

            if (day > 31 || day < 1) {
                System.err.println("Неправильный формат дня! Попробуйте еще раз.");
            } else if (month == 2 && day > 29) {
                System.err.println("Не правильна выбрана дата! ");
            } else {
                break;
            }

        }
        LocalDate dateOfBirth = LocalDate.of(year, month, day);

        //  LocalDate date = LocalDate.of(year, month, day); ??
        csr.nextLine();

        System.out.println("Введите логин: ");
        String Logins = csr.nextLine();


        System.out.println("Введите сумму пополнения: ");
        float balance = csr.nextFloat();
        csr.nextLine();


        String password;
        do {
            System.out.println("Введите пароль: ");
            password = csr.nextLine();

        } while (!isValidPassword(password));  // Повторять, пока пароль не пройдет проверку
        System.out.println("Пароль подходит!");

        Random random = new Random();
        int randomNumber = random.nextInt(90) + 11;

        User newUser = new User(dateOfBirth, Logins, password, randomNumber, balance);
        userList.add(newUser);

        System.out.println("Вывод списка пользователей! ");
        for (User user : userList) {
            System.out.println(user);
        }
        return true;
    }

    //метод для проверки пароля.
    public static boolean isValidPassword(String password) {
        if (password.length() >= 8) {
            // Создаем паттерны для букв, цифр и спецсимволов
            Pattern letter = Pattern.compile("[a-zA-Z]");
            Pattern digit = Pattern.compile("[0-9]");
            Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
            //Pattern eight = Pattern.compile (".{8}");

            // Создаем мэчеры для поиска совпадений
            Matcher hasLetter = letter.matcher(password);
            Matcher hasDigit = digit.matcher(password);
            Matcher hasSpecial = special.matcher(password);

            // Возвращаем true только если есть и буквы, и цифры, и спецсимволы
            return hasLetter.find() && hasDigit.find() && hasSpecial.find();

        } else {
            // Сообщение о слишком коротком пароле
            System.err.println("Пароль должен содержать хотя бы 8 символов, включая букву, цифру и спецсимвол!");
            System.out.println("Попробуйте еще раз! ");
            return false;
        }
    }


    public void UserDelete() {// удалить пользователя из списка
        while (true) {
            System.out.println("Кого вы хотите удалить? Введите id пользователя:  ");
            int delId = csr.nextInt();
            boolean userRemoved = userList.removeIf(userList -> userList.getId() == delId); //ищем по id пользователя, если он есть то удаляем его из коллекции.
            // берем имя userList -> далее делаем метод удаляет все элементы, которые удовлетворяют условию
            // далее берем сам наш List и делаем логику условия в данный момент мы ищем по id  == присваиваем переменной сканера в нашем случае delId
            if (userRemoved) {
                System.out.println("Пользователь с ID " + delId + " был удален.");
                System.out.println();
                System.out.println("Список всех пользователей! ");
                for (User user : userList) {
                    System.out.println(user);
                }
                break;
            } else {
                System.err.println("Пользователь с ID " + delId + " не найден.");
                System.out.println("Попробуйте еще раз!");
            }
        }
    }


    public void UserBalanse() {//вывести всех пользователей, баланс которых выше 1000
        System.out.println();
        System.out.println("Вывод всех пользователей у которых баланс более 1000 руб.");
        for (User user : userList) {
            if (user.getBalans() >= 1000) {
                System.out.println(user);
            }
        }
    }

    public void UserId() {//метод, который возвращает пользователя по id
        System.out.println();
        boolean userFound = false; //флаг для нахождения айди пользователей изначально он folse = если будет такой пользователь то true
        while (userFound != true) {
            System.out.println("Введите id: ");
            int searchId = csr.nextInt();
            // Флаг для проверки, найден ли пользователь

            for (User user : userList) {
                if (searchId == user.getId()) {
                    System.out.println("Пользователь с данным ID " + searchId + " найден!");
                    System.out.println();
                    System.out.println("Дата регистрации: " + user.getDate());
                    System.out.println(("Логин: " + user.getLogin()));
                    System.out.println("Пароль: " + user.getPassword());
                    System.out.println(("ID: " + user.getId()));
                    System.out.println("Баланс: " + user.getBalans());

                    userFound = true; // Пользователь найден
                    break; // Прерываем цикл, так как пользователь найден

                }
            }

            if (!userFound) {
                System.err.println("Пользователь с таким ID " + searchId + " не найден.");
                System.out.println("Попробуйте еще раз");
            }
        }
    }


    public void Userliste( ){
        userList.clear();
        System.out.println(userList + " Список удален");
    }





}

// создать метод по управелению меню, так-же создать
