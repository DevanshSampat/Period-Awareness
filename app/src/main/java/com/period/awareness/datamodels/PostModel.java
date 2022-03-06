package com.period.awareness.datamodels;

import com.google.gson.annotations.SerializedName;

public class PostModel {
    @SerializedName("__id") private String id;
    @SerializedName("question") private String question;
    @SerializedName("askedBy") private String askedBy;
    @SerializedName("created") private String created;

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAskedBy() {
        return askedBy;
    }

    public String getCreated() {
        return created;
    }
}
