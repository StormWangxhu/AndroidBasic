package com.stormwangxhu.androidbasic.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.stormwangxhu.androidbasic.R;
import com.stormwangxhu.androidbasic.commom.BaseActivity;

public class DataBaseActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);

        final MyDatabseHelper myDatabseHelper = new MyDatabseHelper(this, "BookStore.db", null, 2);
        Button createButton = findViewById(R.id.create_database_button);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabseHelper.getWritableDatabase();
            }
        });

        // 向Book表中添加数据
        Button addData = findViewById(R.id.add_data_button);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = myDatabseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();

                // 开始组装第一组数据
                values.put("name", "StormWangxhu");
                values.put("author", "MG");
                values.put("pages", 2525);
                values.put("price", 16.90);
                db.insert("Book", null, values);
                values.clear();

                // 开始组装第二条数据
                values.put("name", "小明");
                values.put("author", "MH");
                values.put("pages", 510);
                values.put("price", 19.95);
                db.insert("Book", null, values);

                Toast.makeText(DataBaseActivity.this, "Add success", Toast.LENGTH_SHORT).show();
            }
        });

        Button queryDataButton = findViewById(R.id.query_data_button);
        queryDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = myDatabseHelper.getWritableDatabase();
                Cursor cursor = db.query("Book", null, null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("DataBaseActivity", "book name is " + name);
                        Log.d("DataBaseActivity", "book author is " + author);
                        Log.d("DataBaseActivity", "book pages is " + pages);
                        Log.d("DataBaseActivity", "book price is " + price);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
    }
}
