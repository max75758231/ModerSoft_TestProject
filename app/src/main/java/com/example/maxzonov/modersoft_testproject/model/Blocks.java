package com.example.maxzonov.modersoft_testproject.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Blocks {

    @SerializedName("categories")
    private ArrayList<Category> categories;

    @SerializedName("shares")
    private Share share;

    @SerializedName("catalog")
    private ArrayList<Catalog> catalogs;

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public Share getShare() {
        return share;
    }

    public void setShare(Share share) {
        this.share = share;
    }

    public ArrayList<Catalog> getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(ArrayList<Catalog> catalogs) {
        this.catalogs = catalogs;
    }
}
