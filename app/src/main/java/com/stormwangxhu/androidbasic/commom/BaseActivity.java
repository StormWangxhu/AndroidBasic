package com.stormwangxhu.androidbasic.commom;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import com.stormwangxhu.androidbasic.broacast.demo.ActivityCollector;
import com.stormwangxhu.androidbasic.broacast.demo.LoginActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity基类
 */
public class BaseActivity extends AppCompatActivity {

    private ForceOfflineReceiver receiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity", getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActvity(this);
    }

    /**
     * 重写生命周期函数，在方法里注册下线广播接收器
     */
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.stormwangxhu.androidbasic.broadcast.demo.FORCE_OFFLINE");
        receiver = new ForceOfflineReceiver();
        registerReceiver(receiver, intentFilter);
    }

    /**
     * 重写生命周期函数，在方法里取消注册
     */
    @Override
    protected void onPause() {
        super.onPause();
        if (receiver != null) {
            unregisterReceiver(receiver);
            receiver = null;
        }
    }

    /**
     * 下线广播接收器
     */
    class ForceOfflineReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Warning");
            builder.setMessage("You are forced to be offline,Please try to login again");
            // 将对话框设置为不可取消
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int witch) {
                    // 销毁所有活动
                    ActivityCollector.finishAll();
                    Intent intent = new Intent(context, LoginActivity.class);
                    // 重新启动LoginActivity
                    context.startActivity(intent);
                }
            });
            builder.show();
        }
    }
}
