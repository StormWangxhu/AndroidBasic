package com.stormwangxhu.androidbasic.basedemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.stormwangxhu.androidbasic.R;
import com.stormwangxhu.androidbasic.commom.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstActivity extends BaseActivity {

    private Button startSecondButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Log.e("FirstActivity", this.toString());
        //初始化操作
        initViews();
    }

    private void initViews() {
        startSecondButton = findViewById(R.id.start_second_button);
        startSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this, "You clicked StartFirstButton", Toast.LENGTH_SHORT).show();
                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String nowFirstActivityTime = format.format(date);
                //启动SecondActivity
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //把当前Activity的时间传给下个活动
                intent.putExtra("time_data", nowFirstActivityTime);
                startActivity(intent);
            }
        });
    }

}
