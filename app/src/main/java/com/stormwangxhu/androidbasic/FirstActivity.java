package com.stormwangxhu.androidbasic;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstActivity extends BaseActivity {

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initViews();//初始化操作
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
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);//启动SecondActivity
                intent.putExtra("extra_data", nowFirstActivityTime);//把当前Activity的时间传给下个活动
                startActivityForResult(intent, 1);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if (requestCode == RESULT_OK) {
                    String datas = data.getStringExtra("extra_data");
                    Log.d("FirstActivity", datas);
                }
                break;
            default:
        }
    }
}
