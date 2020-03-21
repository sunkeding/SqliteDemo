package com.keding.sqlitedemo.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;


/**
 * @author: skd
 * @date 2019-10-18
 * @Desc 数据库管理类
 */
public class DBManager {

    private static final String TAG = "DBManager";
    private static MySQLiteHelper mySQLiteHelper;

    public static MySQLiteHelper getInstance(Context context) {
        if (mySQLiteHelper == null) {
            synchronized (DBManager.class) {
                if (mySQLiteHelper == null) {
                    mySQLiteHelper = new MySQLiteHelper(context);
                }
            }
        }
        return mySQLiteHelper;
    }

    /**
     * 执行sql语句
     *
     * @param db
     * @param sql
     */
    public static void execSql(SQLiteDatabase db, String sql) {
        if (db != null && !TextUtils.isEmpty(sql)) {
            Log.d(TAG,"执行sql:" + sql);
            db.execSQL(sql);
        }

    }

    /**
     * 获取数据库路径,/data/user/0/com.keding.sqliteapp/databases/person
     */
    public static String getDBPath(Context context, String dbName) {
        return context.getDatabasePath(dbName).getPath();
    }

    /**
     * 根据sql语句查询获取Cursor对象
     *
     * @param db            数据库对象
     * @param sql           sql语句
     * @param selectionArgs 查询条件的占位符
     * @return
     */
    public static Cursor selectDataBySql(SQLiteDatabase db, String sql, String[] selectionArgs) {
        Cursor cursor = null;
        if (db != null && !TextUtils.isEmpty(sql)) {
            Log.d(TAG,"查询sql:"+sql);
            cursor = db.rawQuery(sql, selectionArgs);
        }
        return cursor;
    }

}
