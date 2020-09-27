package com.happyfeetexecutivepvtltd.temprature.objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RainObject {

    @SerializedName("1h")
    @Expose
    private String onehour;

    public RainObject(String onehour) {
        this.onehour = onehour;
    }

    public String getOnehour() {
        return onehour;
    }

    public void setOnehour(String onehour) {
        this.onehour = onehour;
    }
}
