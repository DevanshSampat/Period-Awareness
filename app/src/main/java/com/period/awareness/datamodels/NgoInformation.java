package com.period.awareness.datamodels;

import com.google.gson.annotations.SerializedName;

public class NgoInformation {
    @SerializedName("id") private String id;
    @SerializedName("funding") private String funding;
    @SerializedName("__v") private String __v;
        @SerializedName("name") private String name;
        @SerializedName("location")private String location;
        NgoInformation(String id, String funding, String v, String name, String location){
            this.id = id;
            this.funding = funding;
            __v = v;
            this.name = name;
            this.location = location;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding;
    }

    public String get__v() {
        return __v;
    }

    public void set__v(String __v) {
        this.__v = __v;
    }
}
