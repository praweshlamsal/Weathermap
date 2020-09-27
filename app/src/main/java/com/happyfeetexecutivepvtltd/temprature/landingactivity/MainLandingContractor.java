package com.happyfeetexecutivepvtltd.temprature.landingactivity;

public interface MainLandingContractor {
    interface View{
        void upperCardElements(double temp,double min_temp,double max_temp,String sunrise,String sunset,String icon,String currentdetail,String location);

    }
    interface Presenter{
        void requestData();
    }
}
