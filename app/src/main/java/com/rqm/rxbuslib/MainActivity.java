package com.rqm.rxbuslib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rqm.rxlib.RxBus;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.buttom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clock();
            }
        });

    }

    private void clock() {

        RxBus.getInstance().post(101,TAG);
        startActivity(new Intent(this,TwoActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unRegister(this);
    }
}
