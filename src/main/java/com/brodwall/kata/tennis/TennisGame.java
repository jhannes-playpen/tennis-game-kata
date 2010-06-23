package com.brodwall.kata.tennis;

public class TennisGame {

    private int playerOneBalls = 0;
    private int playerTwoBalls = 0;

    public void playerOneScores() {
        playerOneBalls++;
    }

    public void playerTwoScores() {
        playerTwoBalls++;
    }

    public String getScore() {
        if (isWon()) return getLeader() + " Wins";
        if (isDeuce()) return "Deuce";
        if (isEndgame()) return "Advantage " + getLeader();
        if (isEven()) return getScoreName(playerOneBalls) + " All";

        return getScoreName(playerOneBalls) + " " + getScoreName(playerTwoBalls);
    }

    private boolean isDeuce() {
        return isEndgame() && isEven();
    }

    private boolean isEven() {
        return playerOneBalls == playerTwoBalls;
    }

    private boolean isWon() {
        return isEndgame() && playerOneBalls > playerTwoBalls+1 || playerOneBalls+1 < playerTwoBalls;
    }

    private boolean isEndgame() {
        return playerOneBalls >= 4;
    }

    private String getLeader() {
        return playerOneBalls > playerTwoBalls ? "Player One" : "Player Two";
    }

    private String getScoreName(int score) {
        String[] scoreNames = new String[] { "Love", "Fifteen", "Thirty", "Forty" };
        return scoreNames[score];
    }

}
