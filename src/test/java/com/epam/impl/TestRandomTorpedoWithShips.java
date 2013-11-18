package com.epam.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.epam.torpedo.ship.Ship;
import com.epam.torpedo.table.TorpedoTable;

public class TestRandomTorpedoWithShips {

    private RandomTorpedoWithShips underTest;
    private TorpedoTable torpedotable;
    private Ship ship;
    
    @Before
    public void setUp(){
        ship = new Ship(2,2);
        torpedotable = new TorpedoTable();
        underTest = new RandomTorpedoWithShips(torpedotable);
    }
    
    @Test
    public void testFireShouldReturnTrue(){
        //GIVEN
        torpedotable.getTable().add(ship);
        //WHEN
        boolean actual = underTest.fire(2, 2);
        //THEN
        Assert.assertTrue(actual);
    }
    @Test
    public void testFireShouldIncrementTries(){
        //GIVEN
        Integer expected = Integer.valueOf(1);
        //WHEN
        underTest.fire(1, 1);
        Integer actual = Integer.valueOf(underTest.getTries());
        //THEN
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testIncrementScore(){
        //GIVEN
        Integer expected = Integer.valueOf(1);
        //WHEN
        underTest.incrementScore();
        Integer actual = underTest.getScore();
        //THEN
        Assert.assertEquals(expected, actual);
    }
}
