package com.epam.impl;

import com.epam.api.Torpedo;
import com.epam.torpedo.Status;
import com.epam.torpedo.table.EnhancedTorpedoTable;

public class RandomTorpedoWithShapedShips implements Torpedo{

    private int score;
    private int tries;
    private EnhancedTorpedoTable torpedotable;
    public RandomTorpedoWithShapedShips(EnhancedTorpedoTable torpedotable){
        score = 0;
        tries = 0;
        this.torpedotable = torpedotable;
    }
    
    public Status fire(int x, int y) {
        tries++;
        return torpedotable.contains(x, y);
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

    public boolean isWon() {
        return torpedotable.isWon();
    }
}
