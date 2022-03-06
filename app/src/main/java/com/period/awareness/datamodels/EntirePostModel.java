package com.period.awareness.datamodels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class EntirePostModel {
    @SerializedName("questions") private ArrayList<PostModel> postModelArrayList;
    public ArrayList<PostModel> getPostModelArrayList() {
        return postModelArrayList;
    }
}
