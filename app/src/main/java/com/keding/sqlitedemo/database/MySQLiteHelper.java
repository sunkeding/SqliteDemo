package com.keding.sqlitedemo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * @author: skd
 * @date 2019-10-18
 * @Desc MySQLiteHelper
 */
public class MySQLiteHelper extends SQLiteOpenHelper {
    public MySQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MySQLiteHelper(Context context) {
        super(context, DBConfig.TABLE_NAME, null, DBConfig.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " +
                DBConfig.TABLE_NAME +
                "(_id Integer primary key," +
                "name varchar(10)," +
                "age Integer not null)";
        DBManager.execSql(sqLiteDatabase, sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
}
