package com.example.lkj.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lkj.bean.All;
import com.lkj.json_utils.Jx_utils;

import org.json.JSONException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

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
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                Bundle bundle = new Bundle();
                All new_all = new All();

                new_all.setRealtime(all.getRealtime());
                new_all.setWeather(all.getWeather());
                new_all.setLife(all.getLife());
                new_all.setPm(all.getPm());
                bundle.putSerializable("details", new_all);
                intent.putExtra("bundle",bundle);
                startActivity(intent);

            }
        });
    }

    public All parseJSONWithJSONObject(String jsonData) throws JSONException {

        Jx_utils jx_utils = new Jx_utils();
        All all = jx_utils.getAll(jsonData);
        return all;
    }
}

