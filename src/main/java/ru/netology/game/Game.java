package ru.netology.game;

import ru.netology.exceptions.NotRegisteredException;
import ru.netology.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    private HashMap<String, Player> playersList = new HashMap<>();


    public void register(String name, Player player) {
        playersList.put(name, player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = playersList.get(playerName1);
        Player player2 = playersList.get(playerName2);



        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }


        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player2.getStrength() > player1.getStrength()) {
            return 2;
        }

        return 0;
    }

}
