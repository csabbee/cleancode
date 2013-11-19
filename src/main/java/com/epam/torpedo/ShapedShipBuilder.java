package com.epam.torpedo;

import com.epam.torpedo.ship.ShapedShip;
import com.epam.torpedo.ship.SimpleShip;

public class ShapedShipBuilder {

    private ShapedShip shapedship;
    public ShapedShipBuilder(){
        shapedship = new ShapedShip();
    }
    
    public ShapedShipBuilder addToBody(int x, int y) {
        shapedship.addToBody(new SimpleShip(x, y));
        return this;
    }
    
    public ShapedShip build(){
        return shapedship;
    }
}
