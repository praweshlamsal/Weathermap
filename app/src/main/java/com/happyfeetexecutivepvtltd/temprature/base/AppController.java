package com.happyfeetexecutivepvtltd.temprature.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.happyfeetexecutivepvtltd.temprature.R;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppController extends Application {

    ApiService service;
    Gson gson;
    public static Activity mactivity;
    public static final String URL = "http://api.openweathermap.org/data/2.5/";

    public static AppController get(Activity activity) {
        mactivity = activity;
        return (AppController) activity.getApplication();
    }


    public ApiService getService() {
        return service;
    }

    public Gson getGson() {
        return gson;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ApiService.class);
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting().serializeNulls();
        gson = builder.create();


    }
}
