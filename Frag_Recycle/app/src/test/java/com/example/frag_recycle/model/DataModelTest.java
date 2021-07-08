package com.example.frag_recycle.model;

import android.provider.ContactsContract;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataModelTest {
    DataModel dataModel = null;

    @Before
    public void setUp() throws Exception {
        dataModel = new DataModel();
    }

    @Test
    public void  checkname(){
        dataModel.setName("Rohith");
        assertNotNull(dataModel.getName());
        assertEquals("Rohith",dataModel.getName());
    }


    @After
    public void tearDown() throws Exception {
        dataModel = null;
    }
}