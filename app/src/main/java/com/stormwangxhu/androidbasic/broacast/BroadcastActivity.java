package com.stormwangxhu.androidbasic.broacast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.stormwangxhu.androidbasic.R;
import com.stormwangxhu.androidbasic.commom.BaseActivity;

public class BroadcastActivity extends BaseActivity {

    private static final String SCREEN_ON = "android.intent.action.SCREEN_ON";

    private static final String SCREEN_OFF = "android.intent.action.SCREEN_OFF";

    private DynamicRegisterReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        IntentFilter intentFilter = new IntentFilter();
        networkChangeReceiver = new DynamicRegisterReceiver();
        intentFilter.addAction(SCREEN_ON);
        intentFilter.addAction(SCREEN_OFF);
        registerReceiver(networkChangeReceiver, intentFilter);

        // 发送标准广播
        Button sendBroadcastButton = findViewById(R.id.send_broadcast_button);
        sendBroadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.stormwangxhu.androidbasic.MY_BROADCAST");
                sendBroadcast(intent);
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }


    class DynamicRegisterReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(SCREEN_ON)) {
                Log.i("BroadcastActivity", "SCREEN ON");
            } else if (action.equals(SCREEN_OFF)) {
                Log.i("BroadcastActivity", "SCREEN OFF");
            }
        }
    }
}