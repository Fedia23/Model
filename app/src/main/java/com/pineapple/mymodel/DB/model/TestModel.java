package com.pineapple.mymodel.DB.model;

public class TestModel {

    private String name;

    public TestModel(String name) {
        setName(name);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
