package com.stormwangxhu.androidbasic.basedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.stormwangxhu.androidbasic.R;
import com.stormwangxhu.androidbasic.commom.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstActivity extends BaseActivity implements View.OnClickListener {

    private Button button;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        //初始化操作
        initViews();
    }

    private void initViews() {
        button = findViewById(R.id.start_second_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this, "You clicked StartFirstButton", Toast.LENGTH_LONG).show();
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

        progressBar = findViewById(R.id.progess_bar);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_second_button:
                if (progressBar.getVisibility() == View.GONE) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
        }
    }
}
