package com.lkj.json_utils;

import android.util.Log;

import com.lkj.bean.All;
import com.lkj.bean.Life;
import com.lkj.bean.Pm;
import com.lkj.bean.Realtime;
import com.lkj.bean.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LKJ on 2018/6/14.
 */

public class Jx_utils {


    public All getAll(String jsonData) throws JSONException {
        All all = new All();
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONObject result = jsonObject.getJSONObject("result");
        JSONObject realtime = result.getJSONObject("realtime");
        JSONObject life = result.getJSONObject("life");
        JSONObject pm = result.getJSONObject("pm25");
        JSONArray weather = result.getJSONArray("weather");

        Log.d("测试>>>", "getAll: "+getReal(realtime));
        Log.d("测试>>>", "getAll: "+getLife(life));
        Log.d("测试>>>", "getAll: "+getPm(pm));
        Log.d("测试>>>", "getAll: "+getWeather(weather));
        all.setRealtime(getReal(realtime));
        all.setLife(getLife(life));
        all.setPm(getPm(pm));
        all.setWeather(getWeather(weather));

        return all;
    }
    public Realtime getReal(JSONObject realtime) throws JSONException {

        Realtime realB = new Realtime();

        String city_name = realtime.getString("city_name");//地名
        String today_date = realtime.getString("date");//日期
        String realtime_week = realtime.getString("week");//周几
        JSONObject realtime_weather = realtime.getJSONObject("weather");
        String realtime_humidity = realtime_weather.getString("humidity");//湿度
        String realtime_img = realtime_weather.getString("img");
        String realtime_info = realtime_weather.getString("info");
        String realtime_temperature = realtime_weather.getString("temperature");//实时温度
        JSONObject realtime_wind = realtime.getJSONObject("wind");
        String wind_direct = realtime_wind.getString("direct");//风的方向
        String wind_power = realtime_wind.getString("power");//风的力度

        Log.d("地名", "getReal: "+city_name);
        realB.setReal_cityName(city_name);
        realB.setReal_todayDate(today_date);
        realB.setReal_week(realtime_week);
        realB.setReal_humidity(realtime_humidity);
        realB.setReal_img(realtime_img);
        realB.setReal_info(realtime_info);
        realB.setReal_temperature(realtime_temperature);
        realB.setReal_direct(wind_direct);
        realB.setReal_power(wind_power);

        return realB;
    }

    public Life getLife(JSONObject life) throws JSONException {
        Life lifeB = new Life();
        JSONObject life_info = life.getJSONObject("info");
        String life_kongtiao = life_info.getString("kongtiao");
        String life_yundong = life_info.getString("yundong");
        String life_ziwaixian = life_info.getString("ziwaixian");
        String life_ganmao = life_info.getString("ganmao");
        String life_xiche = life_info.getString("xiche");
        String life_wuran = life_info.getString("wuran");
        String life_chuanyi = life_info.getString("chuanyi");

        lifeB.setLife_kongtiao(life_kongtiao);
        lifeB.setLife_yundong(life_yundong);
        lifeB.setLife_ziwaixian(life_ziwaixian);
        lifeB.setLife_ganmao(life_ganmao);
        lifeB.setLife_xiche(life_xiche);
        lifeB.setLife_wuran(life_wuran);
        lifeB.setLife_chuanyi(life_chuanyi);
        return lifeB;
    }

    public Pm getPm(JSONObject pm) throws JSONException {
        Pm pmB = new Pm();
        JSONObject pm_in = pm.getJSONObject("pm25");
        String pm_curPm = pm_in.getString("curPm");
        String pm_pm25_num = pm_in.getString("pm25");
        String pm_pm10_num = pm_in.getString("pm10");
        String pm_quality = pm_in.getString("quality");
        String pm_des = pm_in.getString("des");

        pmB.setPm_curPm(pm_curPm);
        pmB.setPm_pm25_num(pm_pm25_num);
        pmB.setPm_pm10_num(pm_pm10_num);
        pmB.setPm_quality(pm_quality);
        pmB.setPm_des(pm_des);
        return pmB;
    }

    public List<Weather> getWeather(JSONArray weather) throws JSONException {
        Weather weatherB = new Weather();
         List<Weather> allWeather = new ArrayList<>();
        for (int i = 0; i < weather.length(); i++) {
            JSONObject json_weather = weather.getJSONObject(i);

            String weather_date = json_weather.getString("date");//日期
            String weather_week = json_weather.getString("week");//周几
            JSONObject weather_info = json_weather.getJSONObject("info");
            JSONArray weather_info_dawn = weather_info.getJSONArray("dawn");
            String weather_lowest = weather_info_dawn.get(2).toString();//最低温
            JSONArray weather_info_day = weather_info.getJSONArray("day");
            String weather_highest = weather_info_day.get(2).toString();//最高温
            weatherB.setWeather_date(weather_date);
            weatherB.setWeather_week(weather_week);
            weatherB.setWeather_lowest(weather_lowest);
            weatherB.setWeather_highest(weather_highest);
            allWeather.add(weatherB);
        }
        return allWeather;
    }



}
