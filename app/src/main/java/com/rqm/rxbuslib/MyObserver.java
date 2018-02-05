package com.rqm.rxbuslib;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

/**
 * Created by yxc on 2018/01/04.
 */

public class MyObserver implements LifecycleObserver {


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
//        Log.i("MyObserver", "onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
//        Log.i("MyObserver", "onPause");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
//        Log.i("MyObserver", "onCreate");

    }

}
