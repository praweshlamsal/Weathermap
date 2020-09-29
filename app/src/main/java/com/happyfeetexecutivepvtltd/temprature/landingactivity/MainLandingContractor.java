package com.happyfeetexecutivepvtltd.temprature.landingactivity;

import com.happyfeetexecutivepvtltd.temprature.objects.LocationDetailObject;

import java.util.List;

public interface MainLandingContractor {
    interface View{
        void upperCardElements(double temp,double min_temp,double max_temp,String sunrise,String sunset,String icon,String currentdetail,String location);
        void lowerCardElements(List<LocationDetailObject> itemList);
        void errorMessage(String message);

    }
    interface Presenter{
        void requestData(String lon,String lat);
        void searchData(String searchtext);
    }
}
