package com.happyfeetexecutivepvtltd.temprature.landingactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.happyfeetexecutivepvtltd.temprature.R;
import com.happyfeetexecutivepvtltd.temprature.base.OkDialog;
import com.happyfeetexecutivepvtltd.temprature.locationtracker.GpsTracker;
import com.happyfeetexecutivepvtltd.temprature.objects.LocationDetailObject;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @BindView(R.id.search_text)
    TextInputEditText searchText;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.et_search)
    TextInputLayout til_search;

    @BindView(R.id.tv_day)
    TextView tv_day;

    @BindView(R.id.tv_month)
    TextView tv_months;

    LocationDetailAdapter adapter;
    List<LocationDetailObject> itemList = new ArrayList<>();

    private GpsTracker gpsTracker;

    private final static int MY_PERMISSIONS_READ_PHONE_STATE = 400;
    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters

    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_landing);
        ButterKnife.bind(this);
        presenter = new MainLandingPresenter(this, this);
        setuprecuclerview();
        setupTodayDate();
        locationTempratureUpdate();
    }

    public void locationTempratureUpdate(){
        gpsTracker = new GpsTracker(this);
        if(gpsTracker.canGetLocation()){
            double latitude = gpsTracker.getLatitude();
            double longitude = gpsTracker.getLongitude();
            presenter.requestData(String.valueOf(longitude),String.valueOf(latitude));

        }else{
            gpsTracker.showSettingsAlert();
        }
    }


    private void setuprecuclerview() {
        adapter = new LocationDetailAdapter(itemList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void setupTodayDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE/MMM/dd");
        Date date = Calendar.getInstance().getTime();
        String today = formatter.format(date);
        String[] daysSplit = today.split("/");
        tv_day.setText(daysSplit[0]);
        tv_months.setText(daysSplit[2] + " " + daysSplit[1]);
    }

    @Override
    public void upperCardElements(double temp, double min_temp, double max_temp, String sunrise, String sunset, String icon, String currentdetail, String location) {
        DecimalFormat df = new DecimalFormat("#.#");
        tv_rising.setText(df.format(max_temp) + "°C");
        tv_lower.setText(df.format(min_temp) + "°C");
        tv_temp.setText(df.format(temp) + "°C");
        RequestOptions options = new RequestOptions().placeholder(R.mipmap.ic_launcher_round).error(R.mipmap.ic_launcher_round);
        Glide.with(this).load(icon).apply(options).into(imageView);
        tv_sunrise_time.setText(sunrise);
        tv_sunset_time.setText(sunset);
        tv_temprature_type.setText(currentdetail);
        tv_location.setText(location);
        String txt_search = searchText.getText().toString().trim();
        if (!txt_search.isEmpty()) {
            searchText.setText("");
        }

    }

    @Override
    public void lowerCardElements(List<LocationDetailObject> listItem) {
        itemList.clear();
        itemList.addAll(listItem);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void errorMessage(String message) {
        new OkDialog(message, this);
    }

    @OnClick(R.id.searchBtn)
    public void onSearchclick() {
        String txt_search = searchText.getText().toString().trim();
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        searchText.clearFocus();
        if (!txt_search.isEmpty()) {
            presenter.searchData(txt_search);
            adapter.notifyDataSetChanged();
        } else {
            new OkDialog("Search box text is missing.", this);
            adapter.notifyDataSetChanged();
        }
    }

    @OnClick(R.id.relocate)
    public void relocate(){
        locationTempratureUpdate();
    }

    @OnClick(R.id.reload)
    public void onReloadclick() {
        presenter.searchData(tv_location.getText().toString().trim());
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        locationTempratureUpdate();
    }
}
