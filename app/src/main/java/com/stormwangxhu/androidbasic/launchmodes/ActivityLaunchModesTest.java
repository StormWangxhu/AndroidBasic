package com.stormwangxhu.androidbasic.launchmodes;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.stormwangxhu.androidbasic.R;
import com.stormwangxhu.androidbasic.commom.BaseActivity;

/**
 * TODO: 阅读官方文档
 */
public class ActivityLaunchModesTest extends BaseActivity {

    private Button standardButton;

    private Button singleTopButton;

    private Button singleInstanceButton;

    private Button singleTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("ActivityLaunchModesTest", this.toString());
        setContentView(R.layout.activity_launch_modes_test);

        //标准模式演示
        standardButton = findViewById(R.id.standard_button);
        standardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityLaunchModesTest.this, StandardMode.class);
                startActivity(intent);
            }
        });

        //SingleTop模式演示
        singleTopButton = findViewById(R.id.single_top_button);
        singleTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityLaunchModesTest.this, SingleTopMode.class);
                startActivity(intent);
            }
        });

        //SingleTask模式演示
        singleTaskButton = findViewById(R.id.single_task_button);
        singleTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityLaunchModesTest.this, SingleTaskMode.class);
                startActivity(intent);
            }
        });

        //SingleInstance模式演示
        singleInstanceButton = findViewById(R.id.single_instance_button);
        singleInstanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityLaunchModesTest.this, SingleInstanceMode.class);
                startActivity(intent);
            }
        });

    }
}
