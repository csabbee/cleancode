package com.epam.api.strategy;

public interface GameStrategy {

    public String firstTarget();
    public String nextTarget(String input);
    public int getNumberOfGuesses();
}
