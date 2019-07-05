package com.stormwangxhu.androidbasic.service.servicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import com.stormwangxhu.androidbasic.R;
import com.stormwangxhu.androidbasic.commom.BaseActivity;
import com.stormwangxhu.androidbasic.service.threaddemo.ThreadActivity;

import java.util.Random;

public class ServiceDemoActivity extends BaseActivity implements View.OnClickListener {

    /**
     * 得到引用
     */
    private MyServiceByBind.MyBinder myBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBinder = (MyServiceByBind.MyBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo);

        Button startServiceButton = findViewById(R.id.start_service1_button);
        Button stopServiceButton = findViewById(R.id.stop_service2_button);
        Button sumButton = findViewById(R.id.sum_button);
        Button reduceButton = findViewById(R.id.reduce_button);
        Button showUserInfo = findViewById(R.id.show_info);
        startServiceButton.setOnClickListener(this);
        stopServiceButton.setOnClickListener(this);
        showUserInfo.setOnClickListener(this);
        sumButton.setOnClickListener(this);
        reduceButton.setOnClickListener(this);
        Intent intent = new Intent(this, MyServiceByBind.class);
        // 启动服务
        startService(intent);
        // 绑定服务
        bindService(intent, connection, BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_service1_button:
                Intent startIntent = new Intent(ServiceDemoActivity.this, MyServiceByStart.class);
                Intent startThread = new Intent(ServiceDemoActivity.this, ThreadActivity.class);
                startService(startIntent);
                startActivity(startThread);
                break;
            case R.id.stop_service2_button:
                Intent stopIntent = new Intent(ServiceDemoActivity.this, MyServiceByStart.class);
                stopService(stopIntent);
                break;

            case R.id.sum_button:
                Random numRandom = new Random();
                int a = numRandom.nextInt(10);
                int b = numRandom.nextInt(10);
                myBinder.sum(a, b);
                break;
            case R.id.reduce_button:
                Random reduceRandom = new Random();
                int a1 = reduceRandom.nextInt(10);
                int b1 = reduceRandom.nextInt(10);
                myBinder.reduce(a1, b1);
                break;
            case R.id.show_info:
                User user = new User();
                user.setAge(21);
                user.setId(20190704);
                user.setName("stormwanghu");
                myBinder.showUserInfo(user);
                break;
            default:
                break;
        }
    }
}
