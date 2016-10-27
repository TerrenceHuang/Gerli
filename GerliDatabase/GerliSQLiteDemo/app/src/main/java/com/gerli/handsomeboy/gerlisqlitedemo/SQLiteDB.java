package com.gerli.handsomeboy.gerlisqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by HandsomeBoy on 2016/10/27.
 */
class SQLiteDB extends SQLiteOpenHelper {

    private static final int VERSION = 2;

    final String tableName = "Account";

    public SQLiteDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        Log.d("DatabasePosition","DataBase constructor : finish");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DatabasePosition","DataBase Create : Begin");
        final String create = "CREATE TABLE IF NOT EXISTS "
                + tableName + "("
                + "Id" + " INTEGER PRIMARY KEY, "
                + "Name" + " TEXT NOT NULL, "
                + "Money" + " INTEGER NOT NULL,"
                + "Type" + " INTEGER NOT NULL,"
                + "Time" + " TEXT NOT NULL,"
                + "Description" + " TEXT"
                + ")";
        db.execSQL(create);

        Log.d("DatabasePosition","DataBase Create : Finish");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("DatabasePosition","DataBase Upgrade : Begin");

        final String drop = "DROP TABLE " + tableName;
        db.execSQL(drop);
        onCreate(db);

        Log.d("DatabasePosition","DataBase Upgrade : Finish");
    }
}