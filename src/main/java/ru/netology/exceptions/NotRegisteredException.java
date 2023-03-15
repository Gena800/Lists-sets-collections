package ru.netology.exceptions;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String s) {
        super("Player " + s + " not registered");
    }
}
