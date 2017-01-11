package de.sparfuchs_optimus.model;

/**
 * Created by bwpc on 11.01.2017.
 */

public class Bar {

    private String name;
    private String address;

    public Bar(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
