package com.epam.impl;

import com.epam.api.Torpedo;
import com.epam.torpedo.Status;
import com.epam.torpedo.ship.SimpleShip;
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
    
    public Status fire(int x, int y) {
        tries++;
        Status status = Status.MISS;
        if(torpedotable.contains(new SimpleShip(x,y))){
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
