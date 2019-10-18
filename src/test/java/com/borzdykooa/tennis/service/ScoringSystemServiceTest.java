package com.borzdykooa.tennis.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ScoringSystemServiceTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private ScoringSystemService tennisMatchService;

    @Before
    public void init() {
        tennisMatchService = new ScoringSystemService();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void after() {
        System.setOut(originalOut);
    }

    @Test
    public void pointWonByFirstPlayer() {
        tennisMatchService.pointWonBy(1);

        assertEquals("Point won by player 1" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void pointWonBySecondPlayer() {
        tennisMatchService.pointWonBy(2);

        assertEquals("Point won by player 2" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void getScore() {
        tennisMatchService.getScore();

        assertEquals("0 - 0, 0 - 0" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void isSetFinished() {
        List<Integer> wins = Arrays.asList(1, 1, 2, 2, 1, 2, 1, 2, 1, 2, 2, 2, 2, 2, 1, 1, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1);
        for (Integer win : wins) {
            tennisMatchService.pointWonBy(win);
            tennisMatchService.getScore();
        }

        assertEquals("Point won by player 1" + System.lineSeparator() +
                "0 - 0, 15 - 0" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "0 - 0, 30 - 0" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "0 - 0, 30 - 15" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "0 - 0, 30 - 30" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "0 - 0, 40 - 30" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "0 - 0, Deuce" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "0 - 0, Advantage of Player 1" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "0 - 0, Deuce" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "0 - 0, Advantage of Player 1" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "0 - 0, Deuce" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "0 - 0, Advantage of Player 2" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "0 - 1, 0 - 0" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "0 - 1, 0 - 15" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "0 - 1, 0 - 30" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "0 - 1, 15 - 30" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "0 - 1, 30 - 30" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "0 - 1, 30 - 40" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "0 - 1, Deuce" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "0 - 1, Advantage of Player 2" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "0 - 1, Deuce" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "0 - 1, Advantage of Player 2" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "0 - 2, 0 - 0" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "0 - 2, 0 - 15" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "0 - 2, 0 - 30" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "0 - 2, 0 - 40" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "0 - 3, 0 - 0" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "0 - 3, 15 - 0" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "0 - 3, 30 - 0" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "0 - 3, 40 - 0" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "1 - 3, 0 - 0" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "1 - 3, 15 - 0" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "1 - 3, 30 - 0" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "1 - 3, 40 - 0" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "2 - 3, 0 - 0" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "2 - 3, 15 - 0" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "2 - 3, 15 - 15" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "2 - 3, 30 - 15" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "2 - 3, 40 - 15" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "3 - 3, 0 - 0" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "3 - 3, 0 - 15" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "3 - 3, 15 - 15" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "3 - 3, 15 - 30" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "3 - 3, 30 - 30" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "3 - 3, 40 - 30" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "4 - 3, 0 - 0" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "4 - 3, 15 - 0" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "4 - 3, 30 - 0" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "4 - 3, 30 - 15" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "4 - 3, 40 - 15" + System.lineSeparator() +
                "Point won by player 2" + System.lineSeparator() +
                "4 - 3, 40 - 30" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "5 - 3, 0 - 0" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "5 - 3, 15 - 0" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "5 - 3, 30 - 0" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "5 - 3, 40 - 0" + System.lineSeparator() +
                "Point won by player 1" + System.lineSeparator() +
                "6 - 3, Player 1 wins!" + System.lineSeparator(), outContent.toString());
    }
}
