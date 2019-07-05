package com.stormwangxhu.androidbasic.service.threaddemo;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.stormwangxhu.androidbasic.R;
import com.stormwangxhu.androidbasic.commom.BaseActivity;

import androidx.annotation.NonNull;

public class ThreadActivity extends BaseActivity implements View.OnClickListener {

    private static final int SHOW_TEXT = 1;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case SHOW_TEXT:
                    Toast.makeText(ThreadActivity.this, "Nice to meet you", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        Button changeTextButton = findViewById(R.id.change_text);
        changeTextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.change_text:
                // 线程启动方式一
                MyThreadImplDemo2 myThreadImplDemo2 = new MyThreadImplDemo2();
                // 线程启动方式二
                MyThreadExtendsDemo1 myThreadExtendsDemo1 = new MyThreadExtendsDemo1();
                myThreadExtendsDemo1.start();
                new Thread(myThreadImplDemo2).start();
                // 直接实现
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = SHOW_TEXT;
                        handler.sendMessage(message);
                        Log.e("ThreadActivity:", "Run ...");
                    }
                }).start();
                break;
            default:
                break;

        }

    }
}
