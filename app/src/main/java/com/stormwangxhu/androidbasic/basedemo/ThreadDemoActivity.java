package com.stormwangxhu.androidbasic.basedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.stormwangxhu.androidbasic.R;

public class ThreadDemoActivity extends AppCompatActivity implements Runnable{

    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_demo);
        Button button = findViewById(R.id.thread_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ThreadDemoActivity().run();
            }
        });
    }

    @Override
    public void run() {

    }
}
