package com.brodwall.kata.tennis;

public class TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    public String getScore() {
        if (isGameWon()) return leadingPlayer() + " wins";
        if (isDeuce()) return "deuce";
        if (isEndgame()) return "advantage " + leadingPlayer();
        if (isTied()) return getScoreName(playerOneScore) + "-all";

        return getScoreName(playerOneScore) + "-" + getScoreName(playerTwoScore);
    }

    private boolean isTied() {
        return playerOneScore == playerTwoScore;
    }

    private boolean isEndgame() {
        return playerOneScore >= 3 && playerTwoScore >= 3;
    }

    private boolean isDeuce() {
        return isTied() && playerOneScore >= 3;
    }

    private boolean isGameWon() {
        return playerTwoScore > 3 && playerTwoScore > playerOneScore+1
            || playerOneScore > 3 && playerOneScore > playerTwoScore+1;
    }

    private String leadingPlayer() {
        return playerOneScore > playerTwoScore ? "player one" : "player two";
    }

    private String getScoreName(int score) {
        String[] scoreNames = { "love", "fifteen", "thirty", "forty" };
        return scoreNames[score];
    }

    public void playerOneScores() {
        this.playerOneScore++;
    }

    public void playerTwoScores() {
        this.playerTwoScore++;
    }

}
