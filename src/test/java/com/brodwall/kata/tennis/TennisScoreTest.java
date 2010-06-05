package com.brodwall.kata.tennis;

import static org.fest.assertions.Assertions.assertThat;

import org.fest.assertions.StringAssert;
import org.junit.Test;

public class TennisScoreTest {

    private TennisGame game = new TennisGame();

    @Test
    public void gameShouldScoreLoveAllAtStart() throws Exception {
        assertGameScore("Love All");
    }

    @Test
    public void shouldScore15All() throws Exception {
        bothPlayersScore(1);
        assertGameScore("15 All");
    }

    @Test
    public void shouldScore30All() throws Exception {
        bothPlayersScore(2);
        assertGameScore("30 All");
    }

    @Test
    public void shouldScore40All() throws Exception {
        bothPlayersScore(3);
        assertGameScore("40 All");
    }

    @Test
    public void shouldScoreDeuece() throws Exception {
        bothPlayersScore(4);
        assertGameScore("Deuce");
        bothPlayersScore(1);
        assertGameScore("Deuce");
    }

    @Test
    public void shouldScore40Love() throws Exception {
        playerOneScores(3);
        assertGameScore("40 Love");
    }

    @Test
    public void shouldScoreLove40() throws Exception {
        playerTwoScores(3);
        assertGameScore("Love 40");
    }

    @Test
    public void shouldScoreAdvantagePlayerOne() throws Exception {
        bothPlayersScore(4);
        game.playerOneScores();
        assertGameScore("Advantage Player One");
        bothPlayersScore(1);
    }

    @Test
    public void shouldScoreAdvantagePlayerTwo() throws Exception {
        bothPlayersScore(4);
        game.playerTwoScores();
        assertGameScore("Advantage Player Two");
    }

    @Test
    public void shouldScoreWinForPlayerOne() throws Exception {
        playerOneScores(4);
        assertGameScore("Player One Wins");
    }

    @Test
    public void shouldScoreWinForPlayerTwo() throws Exception {
        playerTwoScores(4);
        assertGameScore("Player Two Wins");
    }

    private void playerOneScores(int times) {
        for (int i=0; i<times; i++) {
            game.playerOneScores();
        }
    }

    private void playerTwoScores(int times) {
        for (int i=0; i<times; i++) {
            game.playerTwoScores();
        }
    }

    private void bothPlayersScore(int times) {
        for (int i=0; i<times; i++) {
            game.playerOneScores(); game.playerTwoScores();
        }
    }

    private StringAssert assertGameScore(String score) {
        return assertThat(game.getScore()).isEqualTo(score);
    }

}
