package de.sparfuchs_optimus.model;

/**
 * Definition of a Coupon object.
 */

public class Coupon {

    private String category;
    private String description;
    private String location;

    public Coupon(String category, String description, String location) {
        this.category = category;
        this.description = description;
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }
}
