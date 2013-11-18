package com.epam.torpedo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.epam.torpedo.ship.Ship;
import com.epam.torpedo.table.TorpedoTable;

public class TestTorpedoTable {

    private TorpedoTable underTest;
    private Ship ship;
    
    @Before
    public void setUp(){
        underTest = new TorpedoTable();
        ship = new Ship(2,2);
        underTest.getTable().add(ship);
    }
    
    @Test
    public void testContainsShouldReturnTrue(){
        //GIVEN
        Ship reference = new Ship(2,2);
        //WHEN
        //THEN
        Assert.assertTrue(underTest.contains(reference));        
    }
    @Test
    public void testContainsShouldReturnFalse(){
        //GIVEN
        Ship reference = new Ship(2,3);
        //WHEN
        //THEN
        Assert.assertFalse(underTest.contains(reference));
    }
}
