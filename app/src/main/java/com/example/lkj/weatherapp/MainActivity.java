package com.example.lkj.weatherapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lkj.bean.All;
import com.lkj.json_utils.Jx_utils;

import org.json.JSONException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String APPKEY = "c1cc1b0541b74998b8655a1294730fb2";
    String city = "绵阳";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String new_city = intent.getStringExtra("city");
        if(new_city != null){
            sendRequestWidthOkHttp(new_city);
        }else{
            sendRequestWidthOkHttp(city);
        }
        Button more = findViewById(R.id.more);
        more.setOnClickListener(this);
    }

    private void sendRequestWidthOkHttp(final String city) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url(" http://api.avatardata.cn/Weather/Query?key="+APPKEY+"&cityname="+city)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
//                    Log.d("获得的json", "run: "+responseData);
                    All all = parseJSONWithJSONObject(responseData);
                    showResponse(all);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void showResponse(final All all) {
        runOnUiThread(new Runnable(){
            @Override
            public void run(){
                setAll(all);
            }
        });
    }

    public All parseJSONWithJSONObject(String jsonData) throws JSONException {

        Jx_utils jx_utils = new Jx_utils();
        All all = jx_utils.getAll(jsonData);
        return all;
    }
    public void setAll(All all){
        TextView realtime_cityName_tv = findViewById(R.id.realtime_city);
        TextView realtime_temperature_tv = findViewById(R.id.realtime_temperature);
        TextView realtime_info_tv = findViewById(R.id.realtime_info);
        TextView weather_lowest_temperature_tv = findViewById(R.id.weather_lowest_temperature);
        TextView weather_highest_temperature_tv = findViewById(R.id.weather_highest_temperature);
        TextView pm_quality = findViewById(R.id.pm_quality);//空气质量

        TextView weather_date_more_1 = findViewById(R.id.weather_date_more_1);
        TextView weather_date_more_2 = findViewById(R.id.weather_date_more_2);
        TextView weather_date_more_3 = findViewById(R.id.weather_date_more_3);
        TextView weather_date_more_4 = findViewById(R.id.weather_date_more_4);
        TextView weather_week_more_1 = findViewById(R.id.weather_week_more_1);
        TextView weather_week_more_2 = findViewById(R.id.weather_week_more_2);
        TextView weather_week_more_3 = findViewById(R.id.weather_week_more_3);
        TextView weather_week_more_4 = findViewById(R.id.weather_week_more_4);
        TextView weather_highest_temperature_more_1 = findViewById(R.id.weather_highest_temperature_more_1);
        TextView weather_highest_temperature_more_2 = findViewById(R.id.weather_highest_temperature_more_2);
        TextView weather_highest_temperature_more_3 = findViewById(R.id.weather_highest_temperature_more_3);
        TextView weather_highest_temperature_more_4 = findViewById(R.id.weather_highest_temperature_more_4);
        TextView weather_lowest_temperature_more_1 = findViewById(R.id.weather_lowest_temperature_more_1);
        TextView weather_lowest_temperature_more_2 = findViewById(R.id.weather_lowest_temperature_more_2);
        TextView weather_lowest_temperature_more_3 = findViewById(R.id.weather_lowest_temperature_more_3);
        TextView weather_lowest_temperature_more_4 = findViewById(R.id.weather_lowest_temperature_more_4);
        TextView weather_img_more_1 = findViewById(R.id.realtime_img_more_1);
        TextView weather_img_more_2 = findViewById(R.id.realtime_img_more_2);
        TextView weather_img_more_3 = findViewById(R.id.realtime_img_more_3);
        TextView weather_img_more_4 = findViewById(R.id.realtime_img_more_4);

        TextView pm_quality_tv = findViewById(R.id.quality);//空气质量
        TextView curPm_tv = findViewById(R.id.curPm);
        TextView pm10_num_tv = findViewById(R.id.pm10_num);
        TextView pm25_num_tv = findViewById(R.id.pm25_num);
        TextView des_tv = findViewById(R.id.des);

        TextView wind_direct_tv = findViewById(R.id.wind_direct);
        TextView wind_power_tv = findViewById(R.id.wind_power);



        realtime_cityName_tv.setText(all.getRealtime().getReal_cityName());
        realtime_temperature_tv.setText(all.getRealtime().getReal_temperature()+"°C");
        realtime_info_tv.setText(all.getRealtime().getReal_info());

        pm_quality.setText(all.getPm().getPm_quality());
        pm_quality_tv.setText(all.getPm().getPm_quality());
        curPm_tv.setText(all.getPm().getPm_curPm());
        pm10_num_tv.setText(all.getPm().getPm_pm10_num());
        pm25_num_tv.setText(all.getPm().getPm_pm25_num());
        des_tv.setText(all.getPm().getPm_des());
        wind_direct_tv.setText(all.getRealtime().getReal_direct());
        wind_power_tv.setText(all.getRealtime().getReal_power());
        weather_lowest_temperature_tv.setText(all.getWeather().get(0).getWeather_lowest()+"°C");
        weather_highest_temperature_tv.setText(all.getWeather().get(0).getWeather_highest()+"°C / ");

        weather_lowest_temperature_more_1.setText(all.getWeather().get(1).getWeather_lowest()+"°C");
        weather_highest_temperature_more_1.setText(all.getWeather().get(1).getWeather_highest()+"°C / ");
        weather_lowest_temperature_more_2.setText(all.getWeather().get(2).getWeather_lowest()+"°C");
        weather_highest_temperature_more_2.setText(all.getWeather().get(2).getWeather_highest()+"°C / ");
        weather_lowest_temperature_more_3.setText(all.getWeather().get(3).getWeather_lowest()+"°C");
        weather_highest_temperature_more_3.setText(all.getWeather().get(3).getWeather_highest()+"°C / ");
        weather_lowest_temperature_more_4.setText(all.getWeather().get(4).getWeather_lowest()+"°C");
        weather_highest_temperature_more_4.setText(all.getWeather().get(4).getWeather_highest()+"°C / ");

        weather_date_more_1.setText(all.getWeather().get(1).getWeather_date());
        weather_date_more_2.setText(all.getWeather().get(2).getWeather_date());
        weather_date_more_3.setText(all.getWeather().get(3).getWeather_date());
        weather_date_more_4.setText(all.getWeather().get(4).getWeather_date());

        weather_week_more_1.setText(all.getWeather().get(1).getWeather_week());
        weather_week_more_2.setText(all.getWeather().get(2).getWeather_week());
        weather_week_more_3.setText(all.getWeather().get(3).getWeather_week());
        weather_week_more_4.setText(all.getWeather().get(4).getWeather_week());


        for(int i=0;i<5;i++){
            Drawable real_img = null;
            if(all.getWeather().get(i).getWeather_img().equals("多云")){
                Drawable img = getResources().getDrawable(R.mipmap.duoyun);
                img.setBounds(0,0,img.getMinimumWidth(),img.getMinimumHeight());
                real_img = img;
            }else if(all.getWeather().get(i).getWeather_img().equals("小雨")){
                Drawable img = getResources().getDrawable(R.mipmap.xiaoyu);
                img.setBounds(0,0,img.getMinimumWidth(),img.getMinimumHeight());
                real_img = img;
            }
            else if(all.getWeather().get(i).getWeather_img().equals("大雨")){
                Drawable img = getResources().getDrawable(R.mipmap.dayu);
                img.setBounds(0,0,img.getMinimumWidth(),img.getMinimumHeight());
                real_img = img;
            }
            else if(all.getWeather().get(i).getWeather_img().equals("晴")){
                Drawable img = getResources().getDrawable(R.mipmap.qing);
                img.setBounds(0,0,img.getMinimumWidth(),img.getMinimumHeight());
                real_img = img;
            }
            else if(all.getWeather().get(i).getWeather_img().equals("阵雨")){
                Drawable img = getResources().getDrawable(R.mipmap.zhenyu);
                img.setBounds(0,0,img.getMinimumWidth(),img.getMinimumHeight());
                real_img = img;
            }else if(all.getWeather().get(i).getWeather_img().equals("中雨")){
                Drawable img = getResources().getDrawable(R.mipmap.zhongyu);
                img.setBounds(0,0,img.getMinimumWidth(),img.getMinimumHeight());
                real_img = img;
            }else{
                if(i==1){
                    weather_img_more_1.setText(all.getWeather().get(i).getWeather_img());
                }else if(i==2){
                    weather_img_more_2.setText(all.getWeather().get(i).getWeather_img());
                }else if(i==3){
                    weather_img_more_3.setText(all.getWeather().get(i).getWeather_img());
                }else if(i==4){
                    weather_img_more_4.setText(all.getWeather().get(i).getWeather_img());
                }
            }
            if(i==1){
                weather_img_more_1.setBackground(real_img);
            }else if(i==2){
                weather_img_more_2.setBackground(real_img);
            }else if(i==3){
                weather_img_more_3.setBackground(real_img);
            }else if(i==4){
                weather_img_more_4.setBackground(real_img);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.more){
            Intent intent = new Intent(MainActivity.this,MoreActivity.class);
            startActivity(intent);
        }
    }
}

