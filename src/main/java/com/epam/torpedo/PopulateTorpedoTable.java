package com.epam.torpedo;

import com.epam.torpedo.ship.SimpleShip;
import com.epam.torpedo.table.TorpedoTable;

public class PopulateTorpedoTable {

    private TorpedoTable torpedotable;

    public PopulateTorpedoTable(TorpedoTable torpedotable) {
        super();
        this.torpedotable = torpedotable;
    }

    public void populateTable(){
        while(torpedotable.getTable().size() < 25){
            SimpleShip ship = generateShip();
            if(!torpedotable.getTable().contains(ship)){
                torpedotable.getTable().add(generateShip());
            }
        }
    }
    
    private SimpleShip generateShip(){
        return new SimpleShip((int)(Math.random()*20),(int)(Math.random()*20));
    }
}
