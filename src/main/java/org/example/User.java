package org.example;

import java.time.LocalDate;
import java.util.Objects;


public class User {
   private  LocalDate date ;
    private  String login;
    private  String password;
    private  int id;
    private float balans;


    public User(LocalDate localDate, String login, String password, int id, float balans) {
        this. date = localDate;
        this.login = login;
        this.password = password;
        this.id = id;
        this.balans = balans;
    }

    public User(LocalDate dateOfBirth, String logins, String password, float balance) {
    }

    public LocalDate getLocalDate() {
        return  date;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public float getBalans() {
        return balans;
    }

    public void setLocalDate(LocalDate localDate) {
        this. date = localDate;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setBalans(float balans) {
        this.balans = balans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Float.compare(balans, user.balans) == 0 && Objects.equals(date, user.date) && Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, login, password, id, balans);
    }

    @Override
    public String toString() {
        return "User{" +
                "date=" + date +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", balans=" + balans +
                '}';
    }
}
