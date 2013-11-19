package com.epam.torpedo.table;

import java.util.ArrayList;
import java.util.List;

import com.epam.torpedo.Status;
import com.epam.torpedo.ship.ShapedShip;

public class EnhancedTorpedoTable {

    private List<ShapedShip> table = new ArrayList<>();
    
    public boolean isInterfering(ShapedShip shapedShip){
        boolean result = false;
        for (ShapedShip shapedShipOnTable : table) {
            if(shapedShipOnTable.isInterfering(shapedShip)){
                result = true;
            }
        }
        return result;
    }
    public Status contains(int x, int y){
        Status result = Status.MISS;
        for (ShapedShip shapedShip : table) {
            if(shapedShip.isShipOnPosition(x, y)){
                result = shapedShip.isHit(x, y);
            }
        }
        return result;
    }
    public List<ShapedShip> getTable() {
        return table;
    }
    
    public void setTable(List<ShapedShip> table) {
        this.table = table;
    }
    public boolean isWon() {
        boolean result = true;
        for (ShapedShip shapedShip : table) {
            if(!shapedShip.isSinked()){
                result = false;
            }
        }
        return result;
    }
    
}
