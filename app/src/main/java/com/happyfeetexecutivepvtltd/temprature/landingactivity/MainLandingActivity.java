package com.happyfeetexecutivepvtltd.temprature.landingactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.happyfeetexecutivepvtltd.temprature.R;
import com.happyfeetexecutivepvtltd.temprature.locationtracker.CurrentLocation;
import com.happyfeetexecutivepvtltd.temprature.locationtracker.LocationTraker;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainLandingActivity extends AppCompatActivity implements MainLandingContractor.View {

    MainLandingPresenter presenter;
    @BindView(R.id.tv_rising)
    TextView tv_rising;

    @BindView(R.id.tv_lower)
    TextView tv_lower;

    @BindView(R.id.tv_temprature)
    TextView tv_temp;

    @BindView(R.id.ic_image)
    ImageView imageView;

    @BindView(R.id.tv_temprature_type)
    TextView tv_temprature_type;

    @BindView(R.id.tv_sunrise_time)
    TextView tv_sunrise_time;

    @BindView(R.id.tv_sunset_time)
    TextView tv_sunset_time;

    @BindView(R.id.tv_location)
    TextView tv_location;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_landing);
        ButterKnife.bind(this);
        presenter = new MainLandingPresenter(this,this);
        presenter.requestData();
        requestlocation();
    }


    public void requestlocation(){
        CurrentLocation locationTraker = new CurrentLocation(this);
//        if(locationTraker.canGetLocation()){
//            locationTraker.getLocation();
//            Log.d("locatioupdatedone","location"+locationTraker.getLongitude()+" "+locationTraker.getLatitude());
//
//        }
    }


    @Override
    public void upperCardElements(double temp, double min_temp, double max_temp, String sunrise, String sunset, String icon, String currentdetail, String location) {
        DecimalFormat df = new DecimalFormat("#.##");
        tv_rising.setText(df.format(max_temp)+"°C");
        tv_lower.setText(df.format(min_temp)+"°C");
        tv_temp.setText(df.format(temp)+"°C");
        RequestOptions options = new RequestOptions().placeholder(R.mipmap.ic_launcher_round).error(R.mipmap.ic_launcher_round);
        Glide.with(this).load(icon).apply(options).into(imageView);
        tv_sunrise_time.setText(sunrise);
        tv_sunset_time.setText(sunset);
        tv_temprature_type.setText(currentdetail);
        tv_location.setText(location);
    }
}
