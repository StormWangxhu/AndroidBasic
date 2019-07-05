package com.stormwangxhu.androidbasic.datastorage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.stormwangxhu.androidbasic.R;
import com.stormwangxhu.androidbasic.commom.BaseActivity;

public class SharedPreferencesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        // 保存数据
        Button saveButton = findViewById(R.id.save_data);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "Tom");
                editor.putInt("age", 21);
                editor.putBoolean("married", false);
                editor.apply();
            }
        });

        // 读取数据
        Button restoreButton = findViewById(R.id.restore_data);
        restoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
                String name = sharedPreferences.getString("name", "");
                int age = sharedPreferences.getInt("age", 0);
                boolean married = sharedPreferences.getBoolean("married", false);
                Toast.makeText(SharedPreferencesActivity.this, "name=" + name + ",age=" + age + ",married=" + married, Toast.LENGTH_SHORT).show();
            }
        });

        // IO文件存储演示
        Button ioDemoButton = findViewById(R.id.start_io_show_button);
        ioDemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SharedPreferencesActivity.this, IOActivity.class);
                startActivity(intent);
            }
        });
    }
}
