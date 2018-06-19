package com.example.lkj.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MoreActivity extends AppCompatActivity implements View.OnClickListener {


//    EditText et_area = findViewById(R.id.et_area);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        Button sendRequest = findViewById(R.id.send_request);

        sendRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.send_request) {
            Intent intent = new Intent(MoreActivity.this, MainActivity.class);
//            intent.putExtra("city", et_area.getText());
            startActivity(intent);
        }
    }
}