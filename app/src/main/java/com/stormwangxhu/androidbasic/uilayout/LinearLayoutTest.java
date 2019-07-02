
package com.stormwangxhu.androidbasic.uilayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.stormwangxhu.androidbasic.R;

import androidx.appcompat.app.AppCompatActivity;

public class LinearLayoutTest extends AppCompatActivity {

    //启动相对布局按钮
    private Button relativeButton;

    //启动帧布局按钮
    private Button frameButton;

    //百分比布局按钮
    private Button percentFrameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_test);
        relativeButton = findViewById(R.id.relative_button);
        relativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LinearLayoutTest.this, RelativeLayoutTest.class);
                startActivity(intent);
            }
        });

        frameButton = findViewById(R.id.frame_button);
        frameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LinearLayoutTest.this, FrameLayoutTest.class);
                startActivity(intent);
            }
        });

        percentFrameButton = findViewById(R.id.percent_frame_button);
        percentFrameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LinearLayoutTest.this, PercentFrameLayoutTest.class);
                startActivity(intent);
            }
        });

    }
}
