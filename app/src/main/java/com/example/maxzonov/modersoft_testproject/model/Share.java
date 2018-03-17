package com.example.maxzonov.modersoft_testproject.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Share {

    @SerializedName("count")
    private String count;

    @SerializedName("list")
    private ArrayList<List> lists;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public ArrayList<List> getLists() {
        return lists;
    }

    public void setLists(ArrayList<List> lists) {
        this.lists = lists;
    }
}
