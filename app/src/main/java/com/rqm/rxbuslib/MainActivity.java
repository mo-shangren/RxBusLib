package com.rqm.rxbuslib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
//public class MainActivity extends AppCompatActivity {e

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // 把实现了生命周期感知的MyObserver注册到activity里, 这样一来, 就可以根据注解监听对应的生命周期了
        this.getLifecycle().addObserver(new MyObserver());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        findViewById(R.id.buttom).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                RxBus.getInstance().post(101,TAG);
//            }
//        });

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(MainActivity.this, TestActivity.class));
            }
        });
//        RxBus.getInstance().tObservable(this, 101, String.class, new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
//            }
//        });
//getLi


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        RxBus.getInstance().unRegister(this);
    }
}
