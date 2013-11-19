package com.epam.impl;

import com.epam.api.Torpedo;
import com.epam.torpedo.Status;

public class RandomTorpedo implements Torpedo {

    private int score;
    private int tries;
    
    public RandomTorpedo(){
        score = 0;
        tries = 0;
    }
    
    public Status fire(int x, int y) {
        tries++;
        Status status = Status.MISS;
        if(Math.random() > 0.5){
            status = Status.HIT_AND_SINK;
        }   
        return status;
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