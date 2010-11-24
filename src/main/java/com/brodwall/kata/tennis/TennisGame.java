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
        if (isGameWon()) return getLeadingPlayer() + " wins";
        if (isAdvantage()) return "advantage " + getLeadingPlayer();
        if (isGameDeuce()) return "deuce";
        if (isGameEven()) return getScoreName(playerOneScore) + "-all";
        return getScoreName(playerOneScore) + "-" + getScoreName(playerTwoScore);
    }

    private boolean isGameDeuce() {
        return isGameEven() && getHigherScore() >= 3;
    }

    private boolean isGameWon() {
        return getHigherScore() >= 4 && getHigherScore() > getLowerScore() + 1;
    }

    private boolean isAdvantage() {
        return getHigherScore() >= 4 && getHigherScore() == getLowerScore()+1;
    }

    private boolean isGameEven() {
        return playerOneScore == playerTwoScore;
    }

    private String getScoreName(int score) {
        String[] scoreNames = new String[] { "love", "fifteen", "thirty", "forty" };
        return scoreNames[score];
    }

    private int getHigherScore() {
        return playerOneScore > playerTwoScore ? playerOneScore : playerTwoScore;
    }

    private int getLowerScore() {
        return playerOneScore > playerTwoScore ? playerTwoScore : playerOneScore;
    }

    private String getLeadingPlayer() {
        return playerOneScore > playerTwoScore ? "player one" : "player two";
    }


}
