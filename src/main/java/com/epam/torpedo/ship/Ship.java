package com.epam.torpedo.ship;

public class Ship {

    private int xpositon = 0;
    private int ypositon = 0;
    private boolean sinked = false;

    
    public Ship(int xpositon, int ypositon) {
        super();
        this.xpositon = xpositon;
        this.ypositon = ypositon;
    }

    public int getXpositon() {
        return xpositon;
    }
    
    public int getYpositon() {
        return ypositon;
    }
    
    public void setSinkedTrue(){
        sinked = true;
    }
    
    public boolean getSinked(){
        return sinked;
    }
    
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Ship)){
            return false;
        } else {
            Ship ship = (Ship) o;
            return xpositon == ship.xpositon && ypositon == ship.ypositon ? true : false;
        }
    }

    @Override
    public int hashCode(){
        final int prime = 17;
        int result = 1;
        result = prime * result + xpositon;
        result = prime * result + ypositon;
        return result;
    }
}
