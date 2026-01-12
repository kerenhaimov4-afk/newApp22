package com.example.newapp2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HelperDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "users.db";
    private static final int DATABASE_VERSION = 1;

    public static final String CUSTOMER_TABLE = "USER_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_USER_PASS = "USER_PASS";


    public HelperDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, COLUMN_USER_NAME, factory, version);
    }
    @Override
        public void onCreate(SQLiteDatabase db) {
        String createTableStatement= "CREATE TABLE  USER_TABLE(" + COLUMN_ID + "  INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_NAME + " TEXT , " + COLUMN_USER_PASS + " TEXT)";
        db.execSQL(createTableStatement);
    }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        }
    }

