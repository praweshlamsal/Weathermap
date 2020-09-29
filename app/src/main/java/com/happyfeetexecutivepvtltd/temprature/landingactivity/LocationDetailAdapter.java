package com.happyfeetexecutivepvtltd.temprature.landingactivity;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.happyfeetexecutivepvtltd.temprature.R;
import com.happyfeetexecutivepvtltd.temprature.landingactivity.details_view.LocationDetailView;
import com.happyfeetexecutivepvtltd.temprature.objects.LocationDetailObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LocationDetailAdapter extends RecyclerView.Adapter<LocationDetailView> {

    public List<LocationDetailObject> itemList = new ArrayList<>();
    public Activity a;
    String[] colorlist = {"#38B0DE","#3CB371","#4876FF","#4981CE","#9AC0CD","#A5435C","#A9C9A4","#E35152","#EB5E66","#EE7942","#EEDFCC","#FA8072"};
    Random rand = new Random();

    public LocationDetailAdapter(List<LocationDetailObject> itemList, Activity a) {
        this.itemList = itemList;
        this.a = a;
    }

    @NonNull
    @Override
    public LocationDetailView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_location_detail,parent,false);
        return new LocationDetailView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationDetailView viewholder, int position) {
        LocationDetailView holder = (LocationDetailView) viewholder;
        final LocationDetailObject obj = itemList.get(position);
//        int random_color = rand.nextInt(12);
        holder.setupviews(obj);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
