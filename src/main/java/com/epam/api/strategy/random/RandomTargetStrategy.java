package com.epam.api.strategy.random;

import com.epam.api.strategy.GameStrategy;

public final class RandomTargetStrategy implements GameStrategy {

    private final int boardSize;
    private int numberOfGuesses = 0;
    public RandomTargetStrategy(int boardSize) {
        super();
        this.boardSize = boardSize;
    }

    @Override
    public String nextTarget(String input) {
        numberOfGuesses++;
        int x = ((int)Math.random())*boardSize;
        int y = ((int)Math.random())*boardSize;        
        return convertIntToString(x, y);
    }

    private String convertIntToString(int x, int y){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fire ");
        stringBuilder.append(x);
        stringBuilder.append(" ");
        stringBuilder.append(y);
        return stringBuilder.toString();
    }
    @Override
    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }

    @Override
    public String firstTarget() {
        return nextTarget("first");
    }

}
