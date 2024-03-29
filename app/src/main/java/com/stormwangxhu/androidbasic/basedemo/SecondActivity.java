package com.stormwangxhu.androidbasic.basedemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.stormwangxhu.androidbasic.R;
import com.stormwangxhu.androidbasic.commom.BaseActivity;
import com.stormwangxhu.androidbasic.launchmodes.ActivityLaunchModesTest;

public class SecondActivity extends BaseActivity {

    private Button startLaunchButton;

    private Button showTimeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("SecondActivity:",this.toString());
        setContentView(R.layout.activity_second);
        startLaunchButton = findViewById(R.id.start_launch_button);
        showTimeButton = findViewById(R.id.show_time_button);

        startLaunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDrive = new Intent(SecondActivity.this, ActivityLaunchModesTest.class);
                //启动ActivityLaunchModesTest
                startActivity(intentDrive);
            }
        });

        showTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                String timeData = intent.getStringExtra("time_data");
                Toast.makeText(SecondActivity.this, timeData, Toast.LENGTH_LONG).show();
                Log.d("SecondActivity:", timeData);
            }
        });
    }

}
