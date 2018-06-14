package com.example.lkj.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lkj.bean.All;
import com.lkj.bean.Weather;
import com.lkj.json_utils.Jx_utils;

import org.json.JSONException;

import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_area;


    public static final String APPKEY = "c1cc1b0541b74998b8655a1294730fb2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendRequest = findViewById(R.id.send_request);
        et_area = findViewById(R.id.et_area);
        sendRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.send_request){
            sendRequestWidthOkHttp();
        }
    }

    private void sendRequestWidthOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Log.d("输入的地址", "run: "+et_area.getText());
                    Request request = new Request.Builder()
                            .url(" http://api.avatardata.cn/Weather/Query?key="+APPKEY+"&cityname="+et_area.getText())
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
                TextView weather_highest_temperature_more_1_tv = findViewById(R.id.weather_highest_temperature_more_1);
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




            }
        });
    }

    public All parseJSONWithJSONObject(String jsonData) throws JSONException {

        Jx_utils jx_utils = new Jx_utils();
        All all = jx_utils.getAll(jsonData);
        return all;
    }
}

