package com.happyfeetexecutivepvtltd.temprature.objects;

public class LocationDetailObject {
    String detail_title;
    String detail_value;

    public LocationDetailObject(String detail_title, String detail_value) {
        this.detail_title = detail_title;
        this.detail_value = detail_value;
    }

    public String getDetail_title() {
        return detail_title;
    }

    public void setDetail_title(String detail_title) {
        this.detail_title = detail_title;
    }

    public String getDetail_value() {
        return detail_value;
    }

    public void setDetail_value(String detail_value) {
        this.detail_value = detail_value;
    }
}
