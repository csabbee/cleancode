package com.epam.torpedo.table;

import java.util.ArrayList;
import java.util.List;

import com.epam.torpedo.ship.SimpleShip;

public class TorpedoTable {

    private List<SimpleShip> table = new ArrayList<SimpleShip>();

    public List<SimpleShip> getTable() {
        return table;
    }

    public void setTable(List<SimpleShip> table) {
        this.table = table;
    }

    public boolean contains(SimpleShip ship){
        return table.contains(ship);
    }
    
}
