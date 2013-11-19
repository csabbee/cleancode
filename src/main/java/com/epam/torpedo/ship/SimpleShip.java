package com.epam.torpedo.ship;

public class SimpleShip{

    private int xposition = 0;
    private int yposition = 0;
    private boolean sinked = false;

    
    public SimpleShip(int xpositon, int ypositon) {
        super();
        this.xposition = xpositon;
        this.yposition = ypositon;
    }

    public int getXpositon() {
        return xposition;
    }
    
    public int getYpositon() {
        return yposition;
    }
    
    public boolean isShipOnPosition(int x, int y){
        return x==xposition && y==yposition ? true : false;
    }
    
    public void sinkShip(){
        sinked = true;
    }
    
    public boolean isSinked(){
        return sinked;
    }
    
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof SimpleShip)){
            return false;
        } else {
            SimpleShip ship = (SimpleShip) o;
            return xposition == ship.xposition && yposition == ship.yposition;
        }
    }

    @Override
    public int hashCode(){
        final int prime = 17;
        int result = 1;
        result = prime * result + xposition;
        result = prime * result + yposition;
        return result;
    }
}
