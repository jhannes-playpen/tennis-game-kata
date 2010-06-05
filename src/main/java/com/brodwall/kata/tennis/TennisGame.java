package com.brodwall.kata.tennis;

import java.util.Arrays;
import java.util.List;


public class TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    public String getScore() {
        if (playerOneScore >= 4 || playerTwoScore >= 4) {
            if (playerOneScore == playerTwoScore) {
                return "Deuce";
            } else if (playerOneScore >= playerTwoScore+2) {
                return "Player One Wins";
            } else if (playerTwoScore >= playerOneScore+2) {
                return "Player Two Wins";
            } else if (playerOneScore >= playerTwoScore) {
                return "Advantage Player One";
            } else if (playerTwoScore >= playerOneScore) {
                return "Advantage Player Two";
            }
        }

        if (playerOneScore == playerTwoScore) {
            return getScoreName(playerOneScore) + " All";
        } else {
            return getScoreName(playerOneScore) + " " +
                getScoreName(playerTwoScore);
        }
    }

    private String getScoreName(int score) {
        List<String> scoreNames = Arrays.asList("Love", "15", "30", "40");
        return scoreNames.get(score);
    }

    public void playerOneScores() {
        playerOneScore++;
    }

    public void playerTwoScores() {
        playerTwoScore++;
    }
}
