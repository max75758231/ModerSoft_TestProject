package com.example.maxzonov.modersoft_testproject.model;

import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("title")
    private String title;

    @SerializedName("image")
    private String image;

    @SerializedName("blocks")
    private Blocks blocks;

    public Blocks getBlocks() {
        return blocks;
    }

    public void setBlocks(Blocks blocks) {
        this.blocks = blocks;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
