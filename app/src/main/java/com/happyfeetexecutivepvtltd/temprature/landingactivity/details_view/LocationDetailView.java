package com.happyfeetexecutivepvtltd.temprature.landingactivity.details_view;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.happyfeetexecutivepvtltd.temprature.R;
import com.happyfeetexecutivepvtltd.temprature.objects.LocationDetailObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocationDetailView extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.tv_value)
    TextView tv_value;

    public LocationDetailView(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setupviews(LocationDetailObject obj){
        Log.d("checkingvalue",obj.getDetail_title());
        tv_title.setText(obj.getDetail_title());
        tv_value.setText(obj.getDetail_value());
    }


}
