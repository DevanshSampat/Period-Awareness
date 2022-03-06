package com.period.awareness.datamodels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NgoModel {

    @SerializedName("success") private String success;
    @SerializedName("ngos")private List<NgoInformation> ngos;
    NgoModel(String success,List<NgoInformation> ngos){
        this.success = success;
        this.ngos =ngos;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<NgoInformation> getNgos() {
        return ngos;
    }

    public void setNgos(List<NgoInformation> ngos) {
        this.ngos = ngos;
    }
}

