package com.epam.torpedo;

import com.epam.torpedo.ship.Ship;
import com.epam.torpedo.table.TorpedoTable;

public class PopulateTorpedoTable {

    private TorpedoTable torpedotable;

    public PopulateTorpedoTable(TorpedoTable torpedotable) {
        super();
        this.torpedotable = torpedotable;
    }

    public void populateTable(){
        while(torpedotable.getTable().size() < 25){
            Ship ship = generateShip();
            if(!torpedotable.getTable().contains(ship)){
                torpedotable.getTable().add(generateShip());
            }
        }
    }
    
    private Ship generateShip(){
        return new Ship((int)(Math.random()*20),(int)(Math.random()*20));
    }
}
