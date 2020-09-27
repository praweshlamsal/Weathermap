package com.happyfeetexecutivepvtltd.temprature.locationtracker;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

public class CurrentLocation implements LocationListener {
    private final Context context;
    Location location;
    protected LocationManager locationManager;

    public CurrentLocation(Context context) {
        this.context = context;
        getlocation();
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


    public Location getlocation(){
        try {


        }catch (Exception e){
            Log.d("Error",e.getLocalizedMessage());
        }
        return location;
    }
}
