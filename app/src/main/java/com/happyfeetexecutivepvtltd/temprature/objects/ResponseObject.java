package com.happyfeetexecutivepvtltd.temprature.objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseObject {
    @SerializedName("coord")
    @Expose
    private CordinatesObject coord;

    @SerializedName("weather")
    @Expose
    private List<WeatherObject> weather;

    @SerializedName("base")
    @Expose
    private String base;

    @SerializedName("main")
    @Expose
    private MainObject main;

    @SerializedName("visibility")
    @Expose
    private String visibility;

    @SerializedName("wind")
    @Expose
    private WindObject wind;

    @SerializedName("rain")
    @Expose
    private RainObject rain;

    @SerializedName("clouds")
    @Expose
    private CloudObject clouds;

    @SerializedName("dt")
    @Expose
    private String dt;

    @SerializedName("sys")
    @Expose
    private SysObject sys;

    @SerializedName("timezone")
    @Expose
    private String timezone;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("cod")
    @Expose
    private String cod;

    public ResponseObject(CordinatesObject coord, List<WeatherObject> weather, String base, MainObject main, String visibility, WindObject wind, RainObject rain, CloudObject clouds, String dt, SysObject sys, String timezone, String id, String name, String cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.rain = rain;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public CordinatesObject getCoord() {
        return coord;
    }

    public void setCoord(CordinatesObject coord) {
        this.coord = coord;
    }

    public List<WeatherObject> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherObject> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public MainObject getMain() {
        return main;
    }

    public void setMain(MainObject main) {
        this.main = main;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public WindObject getWind() {
        return wind;
    }

    public void setWind(WindObject wind) {
        this.wind = wind;
    }

    public RainObject getRain() {
        return rain;
    }

    public void setRain(RainObject rain) {
        this.rain = rain;
    }

    public CloudObject getClouds() {
        return clouds;
    }

    public void setClouds(CloudObject clouds) {
        this.clouds = clouds;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public SysObject getSys() {
        return sys;
    }

    public void setSys(SysObject sys) {
        this.sys = sys;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
}
