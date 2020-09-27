package com.happyfeetexecutivepvtltd.temprature.base;

import com.happyfeetexecutivepvtltd.temprature.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    public static ApiService apiService;
    public static final String URL = "http://api.openweathermap.org/data/2.5/";
    public static ApiService getApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
        return apiService;
    }
}
