package com.stormwangxhu.androidbasic;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends BaseActivity {

    private Button startButton;
    private Button showTimeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        startButton = findViewById(R.id.start_launch_button);
        showTimeButton = findViewById(R.id.show_time_button);

        startButton.setOnClickListener(new View.OnClickListener() {
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
