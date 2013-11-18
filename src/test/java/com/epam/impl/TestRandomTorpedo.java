package com.epam.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRandomTorpedo {

    private RandomTorpedo underTest;
    
    @Before
    public void setUp(){
        underTest = new RandomTorpedo();
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
