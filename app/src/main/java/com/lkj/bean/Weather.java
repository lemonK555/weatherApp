package com.lkj.bean;

import java.io.Serializable;

/**
 * Created by LKJ on 2018/6/14.
 */

public class Weather implements Serializable {
    String weather_date;//日期
    String weather_week;//周几
    String weather_lowest;//最低温
    String weather_highest;//最高温

    public String getWeather_date() {
        return weather_date;
    }

    public void setWeather_date(String weather_date) {
        this.weather_date = weather_date;
    }

    public String getWeather_week() {
        return weather_week;
    }

    public void setWeather_week(String weather_week) {
        this.weather_week = weather_week;
    }

    public String getWeather_lowest() {
        return weather_lowest;
    }

    public void setWeather_lowest(String weather_lowest) {
        this.weather_lowest = weather_lowest;
    }

    public String getWeather_highest() {
        return weather_highest;
    }

    public void setWeather_highest(String weather_highest) {
        this.weather_highest = weather_highest;
    }
}
