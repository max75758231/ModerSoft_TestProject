package com.example.maxzonov.modersoft_testproject.model;

import com.google.gson.annotations.SerializedName;

public class Catalog {

    @SerializedName("name")
    private String name;

    @SerializedName("street")
    private String street;

    @SerializedName("house")
    private String house;

    @SerializedName("rating")
    private String rating;

    @SerializedName("image")
    private Image image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
