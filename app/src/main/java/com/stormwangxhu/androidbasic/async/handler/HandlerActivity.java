package com.stormwangxhu.androidbasic.async.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.stormwangxhu.androidbasic.R;
import com.stormwangxhu.androidbasic.commom.BaseActivity;

import java.lang.ref.WeakReference;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HandlerActivity extends BaseActivity implements View.OnClickListener {
    public static final int UPDATE_TEXT = 1;
    private static final String CHANGE_TEXT = "Nice to meet you!";
    private TextView text;
    private MyHandler myHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        myHandler = new MyHandler(this);
        text = findViewById(R.id.textview_text);
        Button changeText = findViewById(R.id.change_text);
        changeText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.change_text:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = UPDATE_TEXT;
                        myHandler.sendMessage(message);
                    }
                }).start();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        // 当传入的参数为null时，则移除所有的callbacks和messages，这样就有效的避免了由Handler引起的内存溢出。
        myHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    static class MyHandler extends Handler {
        private WeakReference<HandlerActivity> weakReference;

        MyHandler(HandlerActivity activity) {
            weakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            HandlerActivity handlerActivity = weakReference.get();
            if (handlerActivity != null) {
                switch (msg.what) {
                    case UPDATE_TEXT:
                        handlerActivity.text.setText(CHANGE_TEXT);
                        break;
                    default:
                        break;
                }
            }
        }
    }

}
