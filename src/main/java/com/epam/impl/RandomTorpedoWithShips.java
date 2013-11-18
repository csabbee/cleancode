package com.epam.impl;

import com.epam.api.Torpedo;
import com.epam.torpedo.ship.Ship;
import com.epam.torpedo.table.TorpedoTable;

public class RandomTorpedoWithShips implements Torpedo{

    private int score;
    private int tries;
    private TorpedoTable torpedotable;
    public RandomTorpedoWithShips(TorpedoTable torpedotable){
        score = 0;
        tries = 0;
        this.torpedotable = torpedotable;
    }
    
    public boolean fire(int x, int y) {
        tries++;
        return torpedotable.contains(new Ship(x,y)) ? true : false;
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
