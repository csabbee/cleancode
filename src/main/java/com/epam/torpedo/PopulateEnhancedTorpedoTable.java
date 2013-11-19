package com.epam.torpedo;

import java.util.ArrayList;
import java.util.List;

import com.epam.torpedo.ship.ShapedShip;
import com.epam.torpedo.table.EnhancedTorpedoTable;

public class PopulateEnhancedTorpedoTable {

    private EnhancedTorpedoTable enhancedtorpedotable;

    public PopulateEnhancedTorpedoTable(EnhancedTorpedoTable enhancedtorpedotable) {
        super();
        this.enhancedtorpedotable = enhancedtorpedotable;
    }
    
    public void populateTable(){
        List<ShapedShip> table = new ArrayList<>();
        ShapedShip shapedShip = null;
        while(shapedShip == null){
            int x = (int)(Math.random()*20);
            int y = (int)(Math.random()*20);
            shapedShip = createTShapedShip(x, y);
        }
        table.add(shapedShip);
        shapedShip = null;
        while(shapedShip == null){
            int x = (int)(Math.random()*20);
            int y = (int)(Math.random()*20);
            shapedShip = createLineShapedShipWithFourBlocks(x, y);
        }
        table.add(shapedShip);
        shapedShip = null;
        while(shapedShip == null){
            int x = (int)(Math.random()*20);
            int y = (int)(Math.random()*20);
            shapedShip = createLineShapedShipWithFourBlocks(x, y);
        }
        table.add(shapedShip);
        shapedShip = null;
        while(shapedShip == null){
            int x = (int)(Math.random()*20);
            int y = (int)(Math.random()*20);
            shapedShip = createLineShapedShipWithThreeBlocks(x, y);
        }
        table.add(shapedShip);
        shapedShip = null;
        while(shapedShip == null){
            int x = (int)(Math.random()*20);
            int y = (int)(Math.random()*20);
            shapedShip = createLineShapedShipWithTwoBlocks(x, y);
        }
        table.add(shapedShip);
        shapedShip = null;
        while(shapedShip == null){
            int x = (int)(Math.random()*20);
            int y = (int)(Math.random()*20);
            shapedShip = createLineShapedShipWithOneBlock(x, y);
        }
        table.add(shapedShip);
        shapedShip = null;
        enhancedtorpedotable.setTable(table);
    }
    
    public ShapedShip createTShapedShip(int x, int y){
        if(x < 0 || x > 17 || y < 0 || y > 19 ){
            throw new IllegalArgumentException("Illegal arguments");
        } else {
            ShapedShipBuilder shapedShipBuilder = new ShapedShipBuilder();
            shapedShipBuilder.addToBody(x, y).addToBody(x+1, y).addToBody(x+2, y).addToBody(x+1, y+1);
            ShapedShip shapedShip = shapedShipBuilder.build();
            if(enhancedtorpedotable.isInterfering(shapedShip)){
                throw new IllegalArgumentException("Another ship on that position");
            }
            return shapedShip;
        }
    }
    
    public ShapedShip createLineShapedShipWithFourBlocks(int x, int y){
        if(x < 0 || x > 16 || y < 0 || y > 19 ){
            throw new IllegalArgumentException("Illegal arguments");
        } else {
            ShapedShipBuilder shapedShipBuilder = new ShapedShipBuilder();
            shapedShipBuilder.addToBody(x, y).addToBody(x+1, y).addToBody(x+2, y).addToBody(x+3, y);
            ShapedShip shapedShip = shapedShipBuilder.build();
            if(enhancedtorpedotable.isInterfering(shapedShip)){
                throw new IllegalArgumentException("Another ship on that position");
            }
            return shapedShip;
        }
    }
    
    public ShapedShip createLineShapedShipWithThreeBlocks(int x, int y){
        if(x < 0 || x > 17 || y < 0 || y > 19 ){
            throw new IllegalArgumentException("Illegal arguments");
        } else {
            ShapedShipBuilder shapedShipBuilder = new ShapedShipBuilder();
            shapedShipBuilder.addToBody(x, y).addToBody(x+1, y).addToBody(x+2, y);
            ShapedShip shapedShip = shapedShipBuilder.build();
            if(enhancedtorpedotable.isInterfering(shapedShip)){
                throw new IllegalArgumentException("Another ship on that position");
            }
            return shapedShip; 
        }
    }
    
    public ShapedShip createLineShapedShipWithTwoBlocks(int x, int y){
        if(x < 0 || x > 18 || y < 0 || y > 19 ){
            throw new IllegalArgumentException("Illegal arguments");
        } else {
            ShapedShipBuilder shapedShipBuilder = new ShapedShipBuilder();
            shapedShipBuilder.addToBody(x, y).addToBody(x+1, y);
            ShapedShip shapedShip = shapedShipBuilder.build();
            if(enhancedtorpedotable.isInterfering(shapedShip)){
                throw new IllegalArgumentException("Another ship on that position");
            }
            return shapedShip; 
        }
    }
    
    public ShapedShip createLineShapedShipWithOneBlock(int x, int y){
        if(x < 0 || x > 19 || y < 0 || y > 19 ){
            throw new IllegalArgumentException("Illegal arguments");
        } else {
            ShapedShipBuilder shapedShipBuilder = new ShapedShipBuilder();
            shapedShipBuilder.addToBody(x, y);
            ShapedShip shapedShip = shapedShipBuilder.build();
            if(enhancedtorpedotable.isInterfering(shapedShip)){
                throw new IllegalArgumentException("Another ship on that position");
            }
            return shapedShip; 
        }
    }
}
