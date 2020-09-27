package com.happyfeetexecutivepvtltd.temprature.base;

import com.google.gson.JsonObject;

public interface OnResponse {
    void onSuccess(JsonObject res);
    void onError(String err);
}
