package com.example.lkj.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lkj.bean.All;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Button more = findViewById(R.id.more);
        more.setOnClickListener(this);
        setAll();
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.more){
            Intent intent = new Intent(DetailsActivity.this,MoreActivity.class);
            startActivity(intent);
        }
    }
    public void setAll(){
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        All all = (All) bundle.getSerializable("details");
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

        TextView pm_quality_tv = findViewById(R.id.quality);//空气质量
        TextView curPm_tv = findViewById(R.id.curPm);
        TextView pm10_num_tv = findViewById(R.id.pm10_num);
        TextView pm25_num_tv = findViewById(R.id.pm25_num);
        TextView des_tv = findViewById(R.id.des);

        TextView wind_direct_tv = findViewById(R.id.wind_direct);
        TextView wind_power_tv = findViewById(R.id.wind_power);



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
        weather_lowest_temperature_tv.setText(all.getWeather().get(0).getWeather_lowest());
        weather_highest_temperature_tv.setText(all.getWeather().get(0).getWeather_highest());

        weather_lowest_temperature_more_1.setText(all.getWeather().get(1).getWeather_lowest());
        weather_highest_temperature_more_1.setText(all.getWeather().get(1).getWeather_highest());
        weather_lowest_temperature_more_2.setText(all.getWeather().get(2).getWeather_lowest());
        weather_highest_temperature_more_2.setText(all.getWeather().get(2).getWeather_highest());
        weather_lowest_temperature_more_3.setText(all.getWeather().get(3).getWeather_lowest());
        weather_highest_temperature_more_3.setText(all.getWeather().get(3).getWeather_highest());
        weather_lowest_temperature_more_4.setText(all.getWeather().get(4).getWeather_lowest());
        weather_highest_temperature_more_4.setText(all.getWeather().get(4).getWeather_highest());

        weather_date_more_1.setText(all.getWeather().get(1).getWeather_date());
        weather_date_more_2.setText(all.getWeather().get(2).getWeather_date());
        weather_date_more_3.setText(all.getWeather().get(3).getWeather_date());
        weather_date_more_4.setText(all.getWeather().get(4).getWeather_date());

        weather_week_more_1.setText(all.getWeather().get(1).getWeather_week());
        weather_week_more_2.setText(all.getWeather().get(2).getWeather_week());
        weather_week_more_3.setText(all.getWeather().get(3).getWeather_week());
        weather_week_more_4.setText(all.getWeather().get(4).getWeather_week());
    }
}
