package com.example.frag_recycle.model;

import java.io.Serializable;

public class DataModel implements Serializable {
    private int id;
    private String name;
    private String rollNumber;

    public DataModel(int id, String name, String rollNumber) {
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
    }
    public DataModel( String name, String rollNumber) {
       
        this.name = name;
        this.rollNumber = rollNumber;
    }
    public DataModel( ) {


    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    public String getData() {
        return rollNumber+name;

    }

}
