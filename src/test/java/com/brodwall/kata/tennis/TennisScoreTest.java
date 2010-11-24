package com.brodwall.kata.tennis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TennisScoreTest {

    private TennisGame game = new TennisGame();

    @Test
    public void loveAll() throws Exception {
        assertEquals("love-all", game.getScore());
    }

    @Test
    public void fifteenAll() throws Exception {
        bothPlayersScore(1);
        assertEquals("fifteen-all", game.getScore());
    }

    @Test
    public void thirtyAll() throws Exception {
        bothPlayersScore(2);
        assertEquals("thirty-all", game.getScore());
    }

    @Test
    public void deuce() throws Exception {
        bothPlayersScore(3);
        assertEquals("deuce", game.getScore());
        bothPlayersScore(100);
        assertEquals("deuce", game.getScore());
    }

    @Test
    public void fifteenLove() throws Exception {
        game.playerOneScores();
        assertEquals("fifteen-love", game.getScore());
    }

    @Test
    public void fifteenThirty() throws Exception {
        bothPlayersScore(1); game.playerTwoScores();
        assertEquals("fifteen-thirty", game.getScore());
    }

    @Test
    public void playerOneCleanWin() throws Exception {
        game.playerOneScores(); game.playerOneScores();
        game.playerOneScores(); game.playerOneScores();
        assertEquals("player one wins", game.getScore());
    }

    @Test
    public void playerTwoWinsWithoutDeuce() throws Exception {
        bothPlayersScore(2);
        game.playerTwoScores(); game.playerTwoScores();
        assertEquals("player two wins", game.getScore());
    }

    @Test
    public void advantagePlayerOne() throws Exception {
        bothPlayersScore(3);
        game.playerOneScores();
        assertEquals("advantage player one", game.getScore());
    }

    @Test
    public void advantagePlayerTwo() throws Exception {
        bothPlayersScore(100);
        game.playerTwoScores();
        assertEquals("advantage player two", game.getScore());
    }

    @Test
    public void playerOneWinsAfterLongTie() throws Exception {
        bothPlayersScore(100);
        game.playerOneScores(); game.playerOneScores();
        assertEquals("player one wins", game.getScore());
    }

    @Test
    public void thirtyForty() throws Exception {
        bothPlayersScore(2);
        game.playerTwoScores();
        assertEquals("thirty-forty", game.getScore());
    }

    protected void bothPlayersScore(int times) {
        for (int i=0; i<times; i++) {
            game.playerOneScores(); game.playerTwoScores();
        }
    }
}
