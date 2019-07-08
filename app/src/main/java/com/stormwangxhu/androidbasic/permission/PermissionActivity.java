package com.stormwangxhu.androidbasic.permission;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.stormwangxhu.androidbasic.R;
import com.stormwangxhu.androidbasic.commom.BaseActivity;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissionActivity extends BaseActivity {

    private static final int MAKE_CALL_PHONE_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        Button makeCall = findViewById(R.id.make_call);
        makeCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 第一步先判断用户是否已经授权
                if (ContextCompat.checkSelfPermission(PermissionActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // 请求授权,此时系统会弹出一个对话框，用户选择同意或者拒绝
                    ActivityCompat.requestPermissions(PermissionActivity.this, new String[]{Manifest.permission.CALL_PHONE}, MAKE_CALL_PHONE_CODE);
                } else {
                    call();
                }
            }
        });
    }

    public void call() {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MAKE_CALL_PHONE_CODE:
                // 同意授权
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    call();
                } else {
                    // 拒绝，弹出提示
                    Toast.makeText(this, "You denied the permisson", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}
