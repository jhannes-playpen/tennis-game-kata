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
        bothPlayersScore(3);
        assertEquals("deuce", game.getScore());
    }

    @Test
    public void fifteenLove() throws Exception {
        game.playerOneScores();
        assertEquals("fifteen-love", game.getScore());
    }

    @Test
    public void loveFifteen() throws Exception {
        game.playerTwoScores();
        assertEquals("love-fifteen", game.getScore());
    }

    @Test
    public void fortyLove() throws Exception {
        game.playerOneScores(); game.playerOneScores(); game.playerOneScores();
        assertEquals("forty-love", game.getScore());
    }

    @Test
    public void advantageIn() throws Exception {
        bothPlayersScore(3);
        game.playerOneScores();
        assertEquals("advantage player one", game.getScore());
    }

    @Test
    public void advantageOut() throws Exception {
        bothPlayersScore(3);
        game.playerTwoScores();
        assertEquals("advantage player two", game.getScore());
    }

    @Test
    public void playerOneWinsCleanly() throws Exception {
        game.playerOneScores(); game.playerOneScores();
        game.playerOneScores(); game.playerOneScores();
        assertEquals("player one wins", game.getScore());
    }

    @Test
    public void playerTwoWins() throws Exception {
        bothPlayersScore(3);
        game.playerTwoScores(); game.playerTwoScores();
        assertEquals("player two wins", game.getScore());
    }


    private void bothPlayersScore(int score) {
        for (int i=0; i<score; i++) {
            game.playerOneScores(); game.playerTwoScores();
        }
    }

}
