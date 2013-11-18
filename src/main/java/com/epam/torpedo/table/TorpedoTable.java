package com.epam.torpedo.table;

import java.util.ArrayList;
import java.util.List;

import com.epam.torpedo.ship.Ship;

public class TorpedoTable {

    private List<Ship> table = new ArrayList<Ship>();

    public List<Ship> getTable() {
        return table;
    }

    public void setTable(List<Ship> table) {
        this.table = table;
    }

    public boolean contains(Ship ship){
        return setShipSinked(ship) ? true : false;
    }
    
    private boolean setShipSinked(Ship ship){
        Integer index = table.indexOf(ship);
        Ship reference = new Ship(Integer.MAX_VALUE,Integer.MAX_VALUE);
        if(index >= 0){
            reference = table.get(index);
            reference.setSinkedTrue();
        }
        return reference.getSinked();
    }
}
