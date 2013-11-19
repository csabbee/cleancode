package com.epam.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.epam.torpedo.Status;
import com.epam.torpedo.ship.SimpleShip;
import com.epam.torpedo.table.TorpedoTable;

public class TestRandomTorpedoWithShips {

    private RandomTorpedoWithShips underTest;
    private TorpedoTable torpedotable;
    private SimpleShip ship;
    
    @Before
    public void setUp(){
        ship = new SimpleShip(2,2);
        torpedotable = new TorpedoTable();
        underTest = new RandomTorpedoWithShips(torpedotable);
    }
    
    @Test
    public void testFireShouldReturnHitAndSink(){
        //GIVEN
        torpedotable.getTable().add(ship);
        Status expected = Status.HIT_AND_SINK;
        //WHEN
        Status actual = underTest.fire(2, 2);
        //THEN
        Assert.assertEquals(expected, actual);
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
