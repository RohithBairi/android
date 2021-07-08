package com.example.frag_recycle;

import com.example.frag_recycle.model.DataModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FragmentBTest {
    DataModel dataModel = null;
    @Before
    public void setUp() throws Exception {
        dataModel = new DataModel(8, "Geetha Govindam", "Vachindamma");
    }
    @Test
    public void ModelData(){
        String Data =dataModel.getRollNumber()+ dataModel.getName();
        assertEquals(dataModel.getData(), Data);
    }

    @After
    public void tearDown() throws Exception {
    }
}