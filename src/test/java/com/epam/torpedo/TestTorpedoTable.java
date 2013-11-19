package com.epam.torpedo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.epam.torpedo.ship.SimpleShip;
import com.epam.torpedo.table.TorpedoTable;

public class TestTorpedoTable {

    private TorpedoTable underTest;
    private SimpleShip ship;
    
    @Before
    public void setUp(){
        underTest = new TorpedoTable();
        ship = new SimpleShip(2,2);
        underTest.getTable().add(ship);
    }
    
    @Test
    public void testContainsShouldReturnTrue(){
        //GIVEN
        SimpleShip reference = new SimpleShip(2,2);
        //WHEN
        //THEN
        Assert.assertTrue(underTest.contains(reference));        
    }
    @Test
    public void testContainsShouldReturnFalse(){
        //GIVEN
        SimpleShip reference = new SimpleShip(2,3);
        //WHEN
        //THEN
        Assert.assertFalse(underTest.contains(reference));
    }
}
