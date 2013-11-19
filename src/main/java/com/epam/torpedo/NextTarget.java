package com.epam.torpedo;

import com.epam.torpedo.ship.SimpleShip;

public class NextTarget {
    
    public SimpleShip newTarget(){
        return new SimpleShip((int)(Math.random()*20), (int)(Math.random()*20));
    }
}
