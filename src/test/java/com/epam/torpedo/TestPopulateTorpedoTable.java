package com.epam.torpedo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.epam.torpedo.table.TorpedoTable;

public class TestPopulateTorpedoTable {

    private PopulateTorpedoTable underTest;
    private TorpedoTable torpedotable;
    
    @Before
    public void setUp(){
        torpedotable = new TorpedoTable();
        underTest = new PopulateTorpedoTable(torpedotable);
    }
    
    @Test
    public void testPopulateTable(){
        //GIVEN
        Integer expected = Integer.valueOf(25);
        //WHEN
        underTest.populateTable();
        Integer actual = torpedotable.getTable().size();
        //THEN
        Assert.assertEquals(expected, actual);        
    }
}
