package com.period.awareness.datamodels;

import com.google.gson.annotations.SerializedName;

public class CreatorData {
    @SerializedName("question") private String question;
    @SerializedName("creatorId") private String id = "aabbcc112233";

    public void setQuestion(String question) {
        this.question = question;
    }
}
