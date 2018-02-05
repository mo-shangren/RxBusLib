package com.rqm.rxbuslib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.rqm.rxlib.RxBus;

import io.reactivex.functions.Consumer;

public class TestActivity extends AppCompatActivity {
//public class MainActivity extends AppCompatActivity {e

    private static final String TAG = "TestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // 生命周期感知demo
        // 把实现了生命周期感知的MyObserver注册到activity里, 这样一来, 就可以根据注解监听对应的生命周期了
        this.getLifecycle().addObserver(new MyObserver());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        // RxBus
        findViewById(R.id.buttom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxBus.getInstance().post(102,"这里是"+TAG);
            }
        });

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestActivity.this, TestActivity.class));
            }
        });

        RxBus.getInstance().tObservable(this, 102, String.class, new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Toast.makeText(TestActivity.this,s,Toast.LENGTH_SHORT).show();
            }
        });
//getLi


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unRegister(this);
    }
}
