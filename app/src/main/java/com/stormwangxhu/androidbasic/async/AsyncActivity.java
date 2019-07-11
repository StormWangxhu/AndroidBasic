package com.stormwangxhu.androidbasic.async;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.stormwangxhu.androidbasic.R;
import com.stormwangxhu.androidbasic.commom.BaseActivity;

public class AsyncActivity extends BaseActivity {
    private TextView txtTitle;
    private ProgressBar pgBar;
    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        txtTitle = findViewById(R.id.txttitle);
        pgBar = findViewById(R.id.pgbar);
        btnUpdate = findViewById(R.id.btnupdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsyncTask myTask = new MyAsyncTask(txtTitle, pgBar);
                myTask.execute(1000);
            }
        });
    }
}
