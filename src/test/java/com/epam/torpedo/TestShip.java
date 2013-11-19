package com.epam.torpedo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.epam.torpedo.ship.SimpleShip;

public class TestShip {

    private SimpleShip underTest;
    
    @Before
    public void setUp(){
        underTest = new SimpleShip(2,2);
    }
    
    @Test
    public void testEqualsWhenItShouldReturnTrue(){
        //GIVEN
        SimpleShip reference = new SimpleShip(2,2);
        //WHEN
        boolean result1 = underTest.equals(reference);
        boolean result2 = reference.equals(underTest);
        //THEN
        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
        Assert.assertEquals(result1, result2);
    }
    @Test
    public void testEqualsMethodWhenItShouldReturnFalse(){
        //GIVEN
        SimpleShip reference = new SimpleShip(2,3);
        //WHEN
        boolean result1 = underTest.equals(reference);
        boolean result2 = reference.equals(underTest);
        //THEN
        Assert.assertFalse(result1);
        Assert.assertFalse(result2);
        Assert.assertEquals(result1, result2);
    }
    @Test
    public void testHashCodeMethodByHand(){
        //GIVEN as in the setup
        //WHEN
        int expected = 325;
        //THEN
        Assert.assertEquals(expected, underTest.hashCode());
    }
    @Test
    public void testHashCodeMethodWithAnotherObject(){
        //GIVEN
        SimpleShip reference = new SimpleShip(2,3);
        //WHEN
        boolean actual = reference.hashCode() == underTest.hashCode() ? true : false;
        //THEN
        Assert.assertFalse(actual);
    }
}
