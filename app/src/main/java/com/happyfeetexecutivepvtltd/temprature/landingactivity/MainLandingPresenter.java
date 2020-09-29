package com.happyfeetexecutivepvtltd.temprature.landingactivity;

import android.app.Activity;
import android.text.format.DateUtils;
import android.util.Log;

import com.google.gson.JsonObject;

import com.happyfeetexecutivepvtltd.temprature.R;
import com.happyfeetexecutivepvtltd.temprature.base.AppController;
import com.happyfeetexecutivepvtltd.temprature.base.OnResponse;
import com.happyfeetexecutivepvtltd.temprature.base.SetRequest;
import com.happyfeetexecutivepvtltd.temprature.objects.LocationDetailObject;
import com.happyfeetexecutivepvtltd.temprature.objects.ResponseObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class MainLandingPresenter implements MainLandingContractor.Presenter {
    MainLandingContractor.View view;
    Activity activity;


    public MainLandingPresenter(MainLandingContractor.View view, Activity activity) {
        this.view = view;
        this.activity = activity;
    }




    @Override
    public void requestData(String lon,String lat) {
        String apikey = activity.getString(R.string.API_KEY);
        new SetRequest().get(activity).set(AppController.get(activity).getService().getCurrentTemprature(lat,lon, apikey))
                .start(new OnResponse() {
                    @Override
                    public void onSuccess(JsonObject res) {
                        ResponseObject responseObject = AppController.get(activity).getGson().fromJson(res.toString(), ResponseObject.class);
                        double temp = kelvinToCelcius(responseObject.getMain().getTemp());
                        String sunrise = UTCtoHour(responseObject.getSys().getSunrise());
                        String sunset = UTCtoHour(responseObject.getSys().getSunset());
                        String currenttime = UTCtoHour(responseObject.getDt());
                        String currentdetail = responseObject.getWeather().get(0).getMain();
                        String icon = getImageUrl(responseObject.getWeather().get(0).getIcon());
                        double temp_min = kelvinToCelcius(responseObject.getMain().getTemp_min());
                        double temp_max = kelvinToCelcius(responseObject.getMain().getTemp_max());
                        String location = responseObject.getName();
                        view.upperCardElements(temp, temp_min, temp_max, sunrise, sunset, icon, currentdetail, location);
                        view.lowerCardElements(setupLowerCard(responseObject));
                    }

                    @Override
                    public void onError(String err) {
                        view.errorMessage(err);
                    }
                });

    }

    public List<LocationDetailObject> setupLowerCard(ResponseObject responseObject) {
        List<LocationDetailObject> locationDetailObjectList = new ArrayList<>();
        locationDetailObjectList.add(new LocationDetailObject("Feels Like", responseObject.getMain().getFeels_like()));
        locationDetailObjectList.add(new LocationDetailObject("Humidity", responseObject.getMain().getHumidity() + "%"));
        locationDetailObjectList.add(new LocationDetailObject("Pressure", responseObject.getMain().getPressure() + "hPa"));
        locationDetailObjectList.add(new LocationDetailObject("Wind Speed", responseObject.getWind().getSpeed() + "m/s"));
        locationDetailObjectList.add(new LocationDetailObject("Wind degree", responseObject.getWind().getDeg() + "°"));
        if (responseObject.getMain().getGrnd_level() != null) {
            locationDetailObjectList.add(new LocationDetailObject("Ground Level", responseObject.getMain().getGrnd_level() + "hPa"));

        }
        if (responseObject.getMain().getSea_level() != null) {
            locationDetailObjectList.add(new LocationDetailObject("Sea Level", responseObject.getMain().getSea_level() + "hPa"));

        }
        if (responseObject.getRain() != null) {
            locationDetailObjectList.add(new LocationDetailObject("Rain", responseObject.getRain().getOnehour() + "mm"));
        }

        return locationDetailObjectList;
    }

    @Override
    public void searchData(String searchtext) {
        String apikey = activity.getString(R.string.API_KEY);
        new SetRequest().get(activity).set(AppController.get(activity).getService().getCurrentTemprature(searchtext, apikey))
                .start(new OnResponse() {
                    @Override
                    public void onSuccess(JsonObject res) {
                        ResponseObject responseObject = AppController.get(activity).getGson().fromJson(res.toString(), ResponseObject.class);
                        double temp = kelvinToCelcius(responseObject.getMain().getTemp());
                        String sunrise = UTCtoHour(responseObject.getSys().getSunrise());
                        String sunset = UTCtoHour(responseObject.getSys().getSunset());
                        String currenttime = UTCtoHour(responseObject.getDt());
                        String currentdetail = responseObject.getWeather().get(0).getMain();
                        String icon = getImageUrl(responseObject.getWeather().get(0).getIcon());
                        double temp_min = kelvinToCelcius(responseObject.getMain().getTemp_min());
                        double temp_max = kelvinToCelcius(responseObject.getMain().getTemp_max());
                        String location = responseObject.getName();
                        view.upperCardElements(temp, temp_min, temp_max, sunrise, sunset, icon, currentdetail, location);
                        view.lowerCardElements(setupLowerCard(responseObject));
                    }

                    @Override
                    public void onError(String err) {
                        view.errorMessage(err);
                    }
                });
    }

    public double kelvinToCelcius(String value) {
        double temprature = Double.valueOf(value);
        double celcius = temprature - 273.15;
        return celcius;
    }

    public String UTCtoHour(String timestamp) {
        long time = Long.parseLong(timestamp);
        Calendar calendar = Calendar.getInstance();
        TimeZone tz = calendar.getTimeZone();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setTimeZone(tz);
        String relTime = sdf.format(new Date(time * 1000));
        return relTime;
    }

    public String getImageUrl(String icon) {
        String url = "http://openweathermap.org/img/wn/" + icon + "@2x.png";
        return url;
    }

}
