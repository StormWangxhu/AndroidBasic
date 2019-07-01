package com.stormwangxhu.androidbasic.launchmodes;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.stormwangxhu.androidbasic.R;
import com.stormwangxhu.androidbasic.commom.BaseActivity;

import androidx.appcompat.app.AlertDialog;

public class StandardMode extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_mode);
        Log.e("StandardMode", this.toString());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.standard_show_button:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(StandardMode.this);
                alertDialog.setTitle("This is Dialog");
                alertDialog.setMessage("Go to logcat");
                alertDialog.setCancelable(false);
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                alertDialog.show();
                break;
            default:
                break;
        }
    }
}
