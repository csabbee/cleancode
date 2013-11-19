package com.epam.torpedo.ship;

import java.util.ArrayList;
import java.util.List;

import com.epam.torpedo.Status;

public class ShapedShip {

    private List<SimpleShip> body = new ArrayList<>();
    
    public void addToBody(SimpleShip simpleship){
        if(!body.contains(simpleship)){
            body.add(simpleship);
        }
    }
    
    public boolean isShipOnPosition(int x, int y){
        boolean result = false;
        for (SimpleShip simpleship : body) {
            if(simpleship.isShipOnPosition(x, y)){
                result = true;
            }
        }
        return result;
    }
    
    public Status isHit(int x, int y){
        Status result = Status.MISS;
        for (SimpleShip simpleship : body) {
            if(simpleship.isShipOnPosition(x, y)){
                result = Status.HIT;
                if(isSinked()){
                    result = Status.HIT_AND_SINK;
                }
            }
        }
        return result;
    }
    
    public void sinkShip(int x, int y){
        for (SimpleShip simpleship : body) {
            if(simpleship.isShipOnPosition(x, y)){
                simpleship.sinkShip();
            }
        }
    }
    
    public boolean isSinked(){
        boolean result = true;
        for (SimpleShip simpleship : body) {
            if(!simpleship.isSinked()){
                result = false;
            }
        }
        return result;
    }
    
    public boolean isInterfering(ShapedShip shapedship){
        boolean result = false;
        for (SimpleShip simpleship : body) {
            if(shapedship.isShipOnPosition(simpleship.getXpositon(), simpleship.getYpositon())){
                result = true;
            }
        }
        return result;
    }
}
