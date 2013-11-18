package com.epam.torpedo;

import com.epam.torpedo.ship.Ship;

public class NextTarget {
    
    public Ship newTarget(){
        return new Ship((int)(Math.random()*20), (int)(Math.random()*20));
    }
}
