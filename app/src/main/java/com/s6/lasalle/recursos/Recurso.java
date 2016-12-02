package com.s6.lasalle.recursos;

public class Recurso {

    private String Name;
    private String Details;

    public Recurso(String name, String details) {
        Name = name;
        Details = details;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }
}
