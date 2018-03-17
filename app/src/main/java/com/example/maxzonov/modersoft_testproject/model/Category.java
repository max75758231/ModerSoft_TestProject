package com.example.maxzonov.modersoft_testproject.model;

import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("name")
    private String name;

    @SerializedName("image")
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
