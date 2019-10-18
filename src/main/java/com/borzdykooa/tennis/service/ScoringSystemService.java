package com.borzdykooa.tennis.service;

import com.borzdykooa.tennis.util.ScoreUtil;

public class ScoringSystemService {
    private static final String PLAYER_1 = "Player 1";
    private static final String PLAYER_2 = "Player 2";
    private static final int MAX_SET_SCORE = 6;
    private static final int DEUCE_NUMBER_OF_SCORES = 3;
    private static final int WIN_NUMBER_OF_SCORES = 4;
    private static final int MIN_WIN_GAP_FOR_GAME_SCORES = 2;
    private static final int ADVANTAGE_GAP_FOR_GAME_SCORES = 1;

    private int firstPlayerSetScoreNumber;
    private int secondPlayerSetScoreNumber;

    private int firstPlayerGameScore;
    private int secondPlayerGameScore;

    public void pointWonBy(int playerNumber) {
        if (playerNumber == 1) {
            firstPlayerGameScore++;
            if (isGameOver()) {
                firstPlayerSetScoreNumber++;
                setGameScoresToNull();
            }
        } else {
            secondPlayerGameScore++;
            if (isGameOver()) {
                secondPlayerSetScoreNumber++;
                setGameScoresToNull();
            }
        }
        System.out.println("Point won by player " + playerNumber);
    }

    public void getScore() {
        System.out.println(firstPlayerSetScoreNumber + " - " + secondPlayerSetScoreNumber + ", " + getGameScoreText());
    }

    public boolean isSetFinished() {
        return firstPlayerSetScoreNumber == MAX_SET_SCORE || secondPlayerSetScoreNumber == MAX_SET_SCORE;
    }

    private void setGameScoresToNull() {
        firstPlayerGameScore = 0;
        secondPlayerGameScore = 0;
    }

    private String getGameScoreText() {
        String gameScoreText;
        if (isDeuce()) {
            gameScoreText = "Deuce";
        } else if (isAdvantage()) {
            gameScoreText = "Advantage of " + getAdvantagePlayer();
        } else if (isSetFinished()) {
            gameScoreText = getSetWinner() + " wins!";
        } else {
            gameScoreText = getScorePoints(firstPlayerGameScore) + " - " + getScorePoints(secondPlayerGameScore);
        }
        return gameScoreText;
    }

    private boolean isDeuce() {
        return secondPlayerGameScore == firstPlayerGameScore && firstPlayerGameScore >= DEUCE_NUMBER_OF_SCORES;
    }

    private boolean isGameOver() {
        return (firstPlayerGameScore >= WIN_NUMBER_OF_SCORES
                && firstPlayerGameScore >= secondPlayerGameScore + MIN_WIN_GAP_FOR_GAME_SCORES)
                || (secondPlayerGameScore >= WIN_NUMBER_OF_SCORES
                && secondPlayerGameScore >= firstPlayerGameScore + MIN_WIN_GAP_FOR_GAME_SCORES);
    }

    private String getSetWinner() {
        String winner;
        if (firstPlayerSetScoreNumber > secondPlayerSetScoreNumber) {
            winner = PLAYER_1;
        } else {
            winner = PLAYER_2;
        }
        return winner;
    }

    private String getAdvantagePlayer() {
        String advantagePlayer;
        if (firstPlayerGameScore > secondPlayerGameScore) {
            advantagePlayer = PLAYER_1;
        } else {
            advantagePlayer = PLAYER_2;
        }
        return advantagePlayer;
    }

    private boolean isAdvantage() {
        return (firstPlayerGameScore >= WIN_NUMBER_OF_SCORES
                && firstPlayerGameScore == secondPlayerGameScore + ADVANTAGE_GAP_FOR_GAME_SCORES)
                || (secondPlayerGameScore >= WIN_NUMBER_OF_SCORES
                && secondPlayerGameScore == firstPlayerGameScore + ADVANTAGE_GAP_FOR_GAME_SCORES);
    }

    private int getScorePoints(int gameScore) {
        return ScoreUtil.getScoresMapper().get(gameScore);
    }
}
