package com.borzdykooa.tennis;

import com.borzdykooa.tennis.service.ScoringSystemService;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        ScoringSystemService tennisService = new ScoringSystemService();
        Random random = new Random();
        while (!tennisService.isSetFinished()) {
            int playerNumber = random.nextInt(2) + 1;
            tennisService.pointWonBy(playerNumber);
            tennisService.getScore();
        }
    }
}
