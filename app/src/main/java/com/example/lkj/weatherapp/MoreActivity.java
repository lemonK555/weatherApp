package com.example.lkj.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MoreActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        TextView zigong = findViewById(R.id.city_zigong);
        TextView chengdu = findViewById(R.id.city_chengdu);
        TextView kunming = findViewById(R.id.city_kunming);

        Button back_home = findViewById(R.id.back_home);
        Button sendRequest = findViewById(R.id.send_request);

        zigong.setOnClickListener(this);
        chengdu.setOnClickListener(this);
        kunming.setOnClickListener(this);
        sendRequest.setOnClickListener(this);
        back_home.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.send_request) {
            EditText et_area = findViewById(R.id.et_area);
            Log.d("输入的地址", "onClick: "+et_area);
            Intent intent = new Intent(MoreActivity.this, MainActivity.class);
            intent.putExtra("city", et_area.getText().toString());
            startActivity(intent);
        }else if(v.getId() == R.id.back_home){
            finish();
        }else {
            Intent intent = new Intent(MoreActivity.this, MainActivity.class);
            if(v.getId() == R.id.city_chengdu){
                intent.putExtra("city","成都");
            }else if(v.getId() == R.id.city_zigong){
                intent.putExtra("city","自贡");
            }else if(v.getId() == R.id.city_kunming){
                intent.putExtra("city","昆明");
            }
            startActivity(intent);
        }
    }
}