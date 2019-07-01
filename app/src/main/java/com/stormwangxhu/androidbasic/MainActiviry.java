package com.stormwangxhu.androidbasic;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 所有的活动都必须在AndroidManifest.xml文件中注册才能生效。
 */
public class MainActiviry extends BaseActivity {

    public static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);//在调用布局文件
        Button startFirstActivity = findViewById(R.id.start_first_activity);
//        Button startSecondActivity = findViewById(R.id.start_second_activity);
//        Button startLaunchModeTest = findViewById(R.id.launch_button);

        startFirstActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActiviry.this, FirstActivity.class);//启动FirstActivity
                startActivity(intent);
            }
        });
//        startSecondActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActiviry.this, SecondActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        startLaunchModeTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActiviry.this, ActivityLaunchModesTest.class);
//                startActivity(intent);
//                Toast.makeText(MainActiviry.this,"This is singleTop Launch Mode Test Button",Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestory");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onReStart");
    }

}
