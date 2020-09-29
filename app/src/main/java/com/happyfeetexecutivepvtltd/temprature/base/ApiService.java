package com.happyfeetexecutivepvtltd.temprature.base;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET(Url_api.current_temprature)
    Call<JsonObject> getCurrentTemprature(@Query("q") String cityname,
                              @Query("appid") String appkey);

    @GET(Url_api.current_temprature)
    Call<JsonObject> getCurrentTemprature(@Query("lat") String latitude,
                                          @Query("lon") String longitude,
                                          @Query("appid") String appkey);
}
