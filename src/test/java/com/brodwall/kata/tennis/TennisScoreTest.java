package com.brodwall.kata.tennis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TennisScoreTest {

    private TennisGame game = new TennisGame();

    @Test
    public void shouldScoreLoveAll() throws Exception {
        assertScore("Love All");
    }

    @Test
    public void shouldScoreFifteenAll() throws Exception {
        bothPlayersScore(1);
        assertScore("Fifteen All");
    }

    @Test
    public void shouldScoreThirtyAll() throws Exception {
        bothPlayersScore(2);
        assertScore("Thirty All");
    }

    @Test
    public void shouldScoreFortyAll() throws Exception {
        bothPlayersScore(3);
        assertScore("Forty All");
    }

    @Test
    public void shouldScoreDeuce() throws Exception {
        bothPlayersScore(4);
        assertScore("Deuce");
    }

    @Test
    public void shouldScoreDeuceWhilePlayersHaveSameScore() throws Exception {
        bothPlayersScore(100);
        assertScore("Deuce");
    }

    @Test
    public void shouldScoreFifteenLove() throws Exception {
        game.playerOneScores();
        assertScore("Fifteen Love");
    }

    @Test
    public void shouldScoreLoveFifteen() throws Exception {
        game.playerTwoScores();
        assertScore("Love Fifteen");
    }

    @Test
    public void shouldScoreAdvantagePlayerOne() throws Exception {
        bothPlayersScore(4);
        game.playerOneScores();
        assertScore("Advantage Player One");
    }

    @Test
    public void shouldScoreAdvantagePlayerTwo() throws Exception {
        bothPlayersScore(4);
        game.playerTwoScores();
        assertScore("Advantage Player Two");
    }

    @Test
    public void shouldScoreWinPlayerOne() throws Exception {
        bothPlayersScore(4);
        game.playerOneScores();
        game.playerOneScores();
        assertScore("Player One Wins");
    }

    @Test
    public void shouldScoreWinPlayerTwo() throws Exception {
        bothPlayersScore(4);
        game.playerTwoScores();
        game.playerTwoScores();
        assertScore("Player Two Wins");
    }

    private void assertScore(String expectedScore) {
        assertEquals(expectedScore, game.getScore());
    }

    private void bothPlayersScore(int times) {
        for (int i=0; i<times; i++) {
            game.playerOneScores(); game.playerTwoScores();
        }
    }

}
