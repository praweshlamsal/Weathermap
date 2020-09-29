package com.happyfeetexecutivepvtltd.temprature.base;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SetRequest {

    Call<JsonObject> call;
    Gson gson = null;
    Activity a;
    SetRequest SetRequest(){
        return this;
    }
    public SetRequest get(Activity activity) {
        this.a = activity;
        gson = AppController.get(activity).getGson();
        return this;
    }


    public static boolean isNetworkConnected(Activity context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    public SetRequest set(Call<JsonObject> c) {
        call = c;
        return this;
    }

    public SetRequest start(final OnResponse r) {
        if (a != null) {
            if (isNetworkConnected(a)) {
                call.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        switch (response.code()) {
                            case 200:
                                r.onSuccess(response.body());
                                break;
                            case 500:
                                r.onError("Server Error. Please try again later.");
                                break;
                            case 400:
                                r.onError("Server Error. Please try again later.");
                                break;
                            default:
                                r.onError("Please enter valid city name.");
                                break;
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Log.d("okayman",t.toString());
                        r.onError("Failed to receive data");
                    }
                });
            } else {

                r.onError("No internet Connection.");
            }
        }
        return this;
    }
}
