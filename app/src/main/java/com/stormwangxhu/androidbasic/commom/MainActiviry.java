package com.stormwangxhu.androidbasic.commom;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.stormwangxhu.androidbasic.R;
import com.stormwangxhu.androidbasic.async.AsyncActivity;
import com.stormwangxhu.androidbasic.basedemo.FirstActivity;
import com.stormwangxhu.androidbasic.broacast.BroadcastActivity;
import com.stormwangxhu.androidbasic.contacts.ContactsDemoActivity;
import com.stormwangxhu.androidbasic.database.DataBaseActivity;
import com.stormwangxhu.androidbasic.datastorage.SharedPreferencesActivity;
import com.stormwangxhu.androidbasic.listviewdemo.arrayadapter.ListViewDemoArrayAdapterActivity;
import com.stormwangxhu.androidbasic.listviewdemo.baseadapter.ListViewDemoBaseAdapterActivity;
import com.stormwangxhu.androidbasic.permission.PermissionActivity;
import com.stormwangxhu.androidbasic.service.servicedemo.ServiceDemoActivity;
import com.stormwangxhu.androidbasic.uilayout.LinearLayoutTest;


public class MainActiviry extends BaseActivity {

    public static final String TAG = "MainActivity";

    private Button startFirstActivityButton;

    // 启动线性布局按钮
    private Button uiButton;

    // 启动listView按钮
    private Button listViewButton;

    private Button listviewAdapterButton;

    // 启动Serice
    private Button serviceStartButton;

    // 运行时权限申请演示按钮
    private Button permissionButton;

    // SharedPreferenced 存储演示按钮
    private Button sharedPreferenceButton;

    // 数据库相关操作Button
    private Button databaseButton;

    private Button contactsButton;

    private Button broadcastButton;

    private Button forceOfflineButton;

    private Button asyncButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);//在调用布局文件
        startFirstActivityButton = findViewById(R.id.start_first_activity);
        uiButton = findViewById(R.id.ui_button);

        startFirstActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActiviry.this, FirstActivity.class);//启动FirstActivity
                startActivity(intent);
            }
        });

        uiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActiviry.this, LinearLayoutTest.class);
                startActivity(intent);
            }
        });

        listViewButton = findViewById(R.id.listview_button);
        listViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActiviry.this, ListViewDemoArrayAdapterActivity.class);
                startActivity(intent);
            }
        });

        listviewAdapterButton = findViewById(R.id.listview_adapter_button);
        listviewAdapterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActiviry.this, ListViewDemoBaseAdapterActivity.class);
                startActivity(intent);
            }
        });

        serviceStartButton = findViewById(R.id.service_button);
        serviceStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActiviry.this, ServiceDemoActivity.class);
                startActivity(intent);
            }
        });

        permissionButton = findViewById(R.id.permision_button);
        permissionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActiviry.this, PermissionActivity.class);
                startActivity(intent);
            }
        });

        sharedPreferenceButton = findViewById(R.id.shared_preference_button);
        sharedPreferenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActiviry.this, SharedPreferencesActivity.class);
                startActivity(intent);
            }
        });

        databaseButton = findViewById(R.id.database_button);
        databaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActiviry.this, DataBaseActivity.class);
                startActivity(intent);
            }
        });

        contactsButton = findViewById(R.id.contacts_button);
        contactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActiviry.this, ContactsDemoActivity.class);
                startActivity(intent);
            }
        });

        broadcastButton = findViewById(R.id.broadcast_button);
        broadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActiviry.this, BroadcastActivity.class);
                startActivity(intent);
            }
        });

        forceOfflineButton = findViewById(R.id.force_offline);
        forceOfflineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.stormwangxhu.androidbasic.broadcast.demo.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });

        asyncButton = findViewById(R.id.async_button);
        asyncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActiviry.this, AsyncActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestory");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onReStart");
    }

}
