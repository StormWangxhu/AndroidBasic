package com.stormwangxhu.androidbasic.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_BOOK = "create table Book ("
            + "id integer primary key autoincrement, "
            + "author text, "
            + "price real, "
            + "pages integer, "
            + "name text )";

    public static final String CREATE_CATEGORY = "create table Category("
            + "id integer primary key autoincrement, "
            + "category_name next,"
            + "category_code integer)";

    private Context context;

    public MyDatabaseHelper(DataBaseActivity dataBaseActivity, String s, Object o, int i) {
        super(dataBaseActivity, s, (SQLiteDatabase.CursorFactory) o, i);
        this.context = dataBaseActivity;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // 创建数据库表
        sqLiteDatabase.execSQL(CREATE_BOOK);
        sqLiteDatabase.execSQL(CREATE_CATEGORY);
        Toast.makeText(context, "Create successded", Toast.LENGTH_SHORT).show();
    }

    /**
     * 升级数据库
     *
     * @param sqLiteDatabase
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("drop table if exists Book");
        sqLiteDatabase.execSQL("drop table if exists Category");
        onCreate(sqLiteDatabase);
    }
}
