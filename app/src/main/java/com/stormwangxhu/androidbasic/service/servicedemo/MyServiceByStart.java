package com.stormwangxhu.androidbasic.service.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyServiceByStart extends Service {


    public MyServiceByStart() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("MyServiceByStart", "onBind executed,ThreadId :" + Thread.currentThread().getId());
        return new MyBinder();
    }

    class MyBinder extends Binder {
        public MyServiceByStart getMyServiceByStart() {
            return MyServiceByStart.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("MyServiceByStart", "onCreate executed,ThreadId :" + Thread.currentThread().getId());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(this.getClass().getName(), "onStartCommand executed,ThreadId :" + Thread.currentThread().getId());
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MyServiceByStart", "onDestory executed,ThreadId :" + Thread.currentThread().getId());
    }
}
