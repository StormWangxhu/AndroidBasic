package com.stormwangxhu.androidbasic.service.servicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.stormwangxhu.androidbasic.R;
import com.stormwangxhu.androidbasic.commom.BaseActivity;

public class ServiceDemoActivity extends BaseActivity implements View.OnClickListener {

    private Button startServiceButton;

    private Button stopServiceButton;

    private Button bindServiceButton;

    private Button unbindServiceButton;

    private EditText editText;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo);

        startServiceButton = findViewById(R.id.start_service1_button);
        startServiceButton.setOnClickListener(this);

        stopServiceButton = findViewById(R.id.stop_service2_button);
        stopServiceButton.setOnClickListener(this);

        bindServiceButton = findViewById(R.id.bind_service_button);
        bindServiceButton.setOnClickListener(this);

        unbindServiceButton = findViewById(R.id.unbind_service_button);
        unbindServiceButton.setOnClickListener(this);

        editText = findViewById(R.id.editText_service);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_service1_button:
                Intent startIntent = new Intent(ServiceDemoActivity.this, MyServiceByStart.class);
                startIntent.putExtra("data", editText.getText().toString());
                startService(startIntent);
                break;
            case R.id.stop_service2_button:
                Intent stopIntent = new Intent(ServiceDemoActivity.this, MyServiceByStart.class);
                stopService(stopIntent);
                break;

            case R.id.bind_service_button:
                Intent bindIntent = new Intent(ServiceDemoActivity.this, MyServiceByBind.class);
                //绑定服务
                bindService(bindIntent, serviceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service_button:
                //解绑服务
                unbindService(serviceConnection);
                break;

            default:
                break;
        }
    }
}
