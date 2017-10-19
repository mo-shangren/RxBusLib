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
                //发送的方法，有点小缺陷，不能发送null
                RxBus.getInstance().post(101,TAG);
            }
        });

        //接收的方法，验证发送的code和发送的数据类型同时通过才会触发
        RxBus.getInstance().tObservable(this, 101, String.class, new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //一般在你的BaseActivity中的onDestroy加上这个方法就行，
        //有生命周期的base类（广播接收者，服务等）里面的onDestroy加上这个，你有用到RxJava的话。
        RxBus.getInstance().unRegister(this);
    }
}
