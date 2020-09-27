package com.happyfeetexecutivepvtltd.temprature.objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CloudObject {
    @SerializedName("all")
    @Expose
    private String all;

    public CloudObject(String all) {
        this.all = all;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }
}
