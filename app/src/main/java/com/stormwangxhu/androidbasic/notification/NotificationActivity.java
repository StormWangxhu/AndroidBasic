package com.stormwangxhu.androidbasic.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.stormwangxhu.androidbasic.R;
import com.stormwangxhu.androidbasic.commom.BaseActivity;

import androidx.core.app.NotificationCompat;

public class NotificationActivity extends BaseActivity {
    private static final String CHANNEL_ID = "2";
    private static final String CHANNEL_NAME = "CHANNEL1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Button sendNoticeButton = findViewById(R.id.send_notice_button);
        sendNoticeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
                    Intent intent = new Intent(NotificationActivity.this, NotificationTestActivity.class);
                    PendingIntent pi = PendingIntent.getActivity(NotificationActivity.this, 0, intent, 0);
                    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    manager.createNotificationChannel(notificationChannel);
                    Notification notification = new NotificationCompat.Builder(NotificationActivity.this, CHANNEL_ID)
                            .setContentTitle("This is content title")
                            .setContentText("This is content text")
                            .setWhen(System.currentTimeMillis())
                            .setSmallIcon(R.drawable.fruit_6)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.fruit_3))
                            .setVibrate(new long[]{0, 1000, 0, 1000}) // 震动
                            .setDefaults(Notification.DEFAULT_SOUND) // 提示音
                            .setAutoCancel(true) // 自动取消
                            .setContentIntent(pi)
                            .build();
                    manager.notify(2, notification);
                } else {
                    // 兼容低版本
                    Intent intent = new Intent(NotificationActivity.this, NotificationTestActivity.class);
                    PendingIntent pi = PendingIntent.getActivity(NotificationActivity.this, 0, intent, 0);
                    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    Notification notification = new NotificationCompat.Builder(NotificationActivity.this)
                            .setContentTitle("This is content title")
                            .setContentText("This is content text")
                            .setWhen(System.currentTimeMillis())
                            .setSmallIcon(R.drawable.fruit_6)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.fruit_3))
                            .setVibrate(new long[]{0, 1000, 0, 1000}) // 震动
                            .setDefaults(Notification.DEFAULT_SOUND) // 提示音
                            .setAutoCancel(true) // 自动取消
                            .setContentIntent(pi)
                            .build();
                    manager.notify(2, notification);
                }

            }
        });
    }
}
