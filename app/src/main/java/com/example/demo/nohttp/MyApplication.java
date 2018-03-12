package com.example.demo.nohttp;

import android.app.Application;

import com.yolanda.nohttp.NoHttp;

/**
 * Created by 59246 on 2018/3/12.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NoHttp.initialize(this);

    }
}
