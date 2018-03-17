package com.example.maxzonov.modersoft_testproject.model;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("origin")
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
