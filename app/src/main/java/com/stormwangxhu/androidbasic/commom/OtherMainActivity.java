package com.stormwangxhu.androidbasic.commom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.stormwangxhu.androidbasic.R;
import com.stormwangxhu.androidbasic.async.handler.HandlerActivity;
import com.stormwangxhu.androidbasic.notification.NotificationActivity;

public class OtherMainActivity extends BaseActivity {
    private Button handlerButton;
    private Button notificationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_main);

        handlerButton = findViewById(R.id.handler_button);
        handlerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtherMainActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });

        notificationButton = findViewById(R.id.notification_button);
        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtherMainActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });
    }
}
