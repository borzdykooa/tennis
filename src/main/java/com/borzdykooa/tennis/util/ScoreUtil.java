package com.borzdykooa.tennis.util;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class ScoreUtil {
    private static Map<Integer, Integer> scoresMapper;

    static {
        scoresMapper = new HashMap<>();
        scoresMapper.put(0, 0);
        scoresMapper.put(1, 15);
        scoresMapper.put(2, 30);
        scoresMapper.put(3, 40);
    }

    public static Map<Integer, Integer> getScoresMapper() {
        return scoresMapper;
    }
}
