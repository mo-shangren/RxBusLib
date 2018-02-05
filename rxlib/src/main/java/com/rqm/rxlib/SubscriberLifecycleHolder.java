package com.rqm.rxlib;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by yxc on 2018/02/05.
 */
public class SubscriberLifecycleHolder implements LifecycleObserver {
    private String TAG = "SubscriberLifecycleHolder";

    private LifecycleOwner lifecycleOwner;

    SubscriberLifecycleHolder(@NonNull LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        RxBus.getInstance().unRegister(lifecycleOwner);
        lifecycleOwner = null;
        Log.i(TAG, "onDestroy-End");
    }

}
