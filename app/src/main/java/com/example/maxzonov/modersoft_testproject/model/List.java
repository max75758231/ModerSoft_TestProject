package com.example.maxzonov.modersoft_testproject.model;

import com.google.gson.annotations.SerializedName;

public class List {

    @SerializedName("name")
    private String name;

    @SerializedName("icon")
    private String iconUrl;

    @SerializedName("company_name")
    private String companyName;

    @SerializedName("company_image")
    private String companyImage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyImage() {
        return companyImage;
    }

    public void setCompanyImage(String companyImage) {
        this.companyImage = companyImage;
    }
}
