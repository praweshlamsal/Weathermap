package com.happyfeetexecutivepvtltd.temprature.objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CordinatesObject {
    @SerializedName("lon")
    @Expose
    private String lon;

    @SerializedName("lat")
    @Expose
    private String lat;


    public CordinatesObject(String lon, String lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
