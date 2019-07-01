package com.stormwangxhu.androidbasic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Result;

public class SecondActivity extends BaseActivity {

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button = findViewById(R.id.start_launch_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this,"You clicked StartSecondButton",Toast.LENGTH_SHORT).show();
                Intent intent = getIntent();
                String data = intent.getStringExtra("extra_data");
                setResult(RESULT_OK,intent);
                Log.d("data", data);
                finish();
            }
        });
    }

}
