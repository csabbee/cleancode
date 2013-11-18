package com.epam.impl;

import com.epam.api.Torpedo;

public class RandomTorpedo implements Torpedo {

    private int score;
    private int tries;
    public RandomTorpedo(){
        score = 0;
        tries = 0;
    }
    public boolean fire(int x, int y) {
        tries++;
        return Math.random() > 0.5 ? true : false;
    }
    public int getScore() {
        return score;
    }
    public void incrementScore() {
        score++;
    }
    public int getTries() {
        return tries;
    }

}
