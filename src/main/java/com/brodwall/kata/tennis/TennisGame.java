package com.brodwall.kata.tennis;

public class TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    public void playerOneScores() {
        this.playerOneScore++;
    }

    public void playerTwoScores() {
        this.playerTwoScore++;
    }

    public String getScore() {
        if (isGameWon()) return leadingPlayer() + " wins";
        if (isAdvantage()) return "advantage " + leadingPlayer();
        if (isDeuce()) return "deuce";
        if (isMatched()) return getScoreName(playerOneScore) + "-all";

        return getScoreName(playerOneScore) + "-" + getScoreName(playerTwoScore);
    }

    private boolean isGameWon() {
        return getHighestScore() >= 4 && getHighestScore() > getLowestScore()+1;
    }

    private boolean isAdvantage() {
        return getHighestScore() >= 4 && !isMatched();
    }

    private boolean isDeuce() {
        return isMatched() && getLowestScore() >= 3;
    }

    private boolean isMatched() {
        return playerOneScore == playerTwoScore;
    }

    private int getHighestScore() {
        return playerOneScore > playerTwoScore ? playerOneScore : playerTwoScore;
    }

    private int getLowestScore() {
        return playerOneScore > playerTwoScore ? playerTwoScore : playerOneScore;
    }

    private String leadingPlayer() {
        return playerOneScore > playerTwoScore ? "player one" : "player two";
    }

    private String getScoreName(int score) {
        String[] scoreNames = { "love", "fifteen", "thirty", "forty" };
        return scoreNames[score];
    }

}
