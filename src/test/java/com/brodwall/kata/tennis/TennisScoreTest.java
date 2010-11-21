package com.brodwall.kata.tennis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TennisScoreTest {

    private TennisGame tennisGame = new TennisGame();

    @Test
    public void loveAll() throws Exception {
        assertEquals("love-all", tennisGame.getScore());
    }

    @Test
    public void fifteenAll() throws Exception {
        bothPlayersScore(1);
        assertEquals("fifteen-all", tennisGame.getScore());
    }

    @Test
    public void thirtyAll() throws Exception {
        bothPlayersScore(2);
        assertEquals("thirty-all", tennisGame.getScore());
    }

    @Test
    public void deuce() throws Exception {
        bothPlayersScore(3);
        assertEquals("deuce", tennisGame.getScore());
        bothPlayersScore(100);
        assertEquals("deuce", tennisGame.getScore());
    }

    @Test
    public void fifteenLove() throws Exception {
        tennisGame.playerOneScores();
        assertEquals("fifteen-love", tennisGame.getScore());
    }

    @Test
    public void loveFifteen() throws Exception {
        tennisGame.playerTwoScores();
        assertEquals("love-fifteen", tennisGame.getScore());
    }

    @Test
    public void loveForty() throws Exception {
        tennisGame.playerTwoScores(); tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();
        assertEquals("love-forty", tennisGame.getScore());
    }

    @Test
    public void advantageIn() throws Exception {
        bothPlayersScore(3);
        tennisGame.playerOneScores();
        assertEquals("advantage player one", tennisGame.getScore());
    }

    @Test
    public void advantageOut() throws Exception {
        bothPlayersScore(3);
        tennisGame.playerTwoScores();
        assertEquals("advantage player two", tennisGame.getScore());
    }

    @Test
    public void cleanWin() throws Exception {
        tennisGame.playerTwoScores(); tennisGame.playerTwoScores();
        tennisGame.playerTwoScores(); tennisGame.playerTwoScores();
        assertEquals("player two wins", tennisGame.getScore());
    }

    @Test
    public void playerOneWins() throws Exception {
        bothPlayersScore(3);
        tennisGame.playerOneScores(); tennisGame.playerOneScores();
        assertEquals("player one wins", tennisGame.getScore());
    }

    private void bothPlayersScore(int score) {
        for (int i = 0; i < score; i++) {
            tennisGame.playerOneScores();
            tennisGame.playerTwoScores();
        }
    }

}
