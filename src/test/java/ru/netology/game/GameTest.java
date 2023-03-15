package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.exceptions.NotRegisteredException;
import ru.netology.player.Player;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();
    Player one = new Player(1, "Petya", 10);
    Player two = new Player(2, "Kolya", 10);
    Player three = new Player(3, "Sveta", 34);
    Player four = new Player(4, "Olya", 9);

    @BeforeEach
    public void setUp() {
        game.register(one);
        game.register(two);
        game.register(three);
        game.register(four);
    }

    @Test
    public void shouldFindWhinerIfPlayer2More() {

        int expected = 2;
        int actual = game.round("Petya", "Sveta");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindWhinerIfPlayer1More() {

        int expected = 1;
        int actual = game.round("Petya", "Olya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindWhinerIfPlayersEqual() {

        int expected = 0;
        int actual = game.round("Petya", "Kolya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void FindWhinerIfPlayer2NotRegister() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Petya", "Kirill");
        });
    }

    @Test
    public void FindWhinerIfPlayer1NotRegister() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Kirill", "Petya");
        });
    }
}