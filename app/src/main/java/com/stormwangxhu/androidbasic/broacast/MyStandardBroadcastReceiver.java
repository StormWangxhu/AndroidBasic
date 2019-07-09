package com.stormwangxhu.androidbasic.broacast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyStandardBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Received in MyStandardBroadcastReceiver", Toast.LENGTH_SHORT).show();
        // 将这条广播截断
        abortBroadcast();
    }
}
