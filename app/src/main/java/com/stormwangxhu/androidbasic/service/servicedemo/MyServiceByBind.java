package com.stormwangxhu.androidbasic.service.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyServiceByBind extends Service {

    private String data="";

    private boolean isRun;

    public MyServiceByBind() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("MyServiceByBind", "onBind executed,ThreadId :" + Thread.currentThread().getId());
        // TODO: Return the communication channel to the service.
        return null;
//        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        data = intent.getStringExtra("data");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        isRun = true;
        new Thread() {
            @Override
            public void run() {
                while (isRun) {
                    Log.d("MyServiceByBind", "Service中获取到的数据:"+data);
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isRun = false;
    }
}
