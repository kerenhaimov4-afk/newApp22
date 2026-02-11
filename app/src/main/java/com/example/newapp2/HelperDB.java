package com.example.newapp2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

    public class HelperDB extends SQLiteOpenHelper {

        public static final String DB_FILE = "info.db";
        public static final String USER_TABLE = "user_table";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_USER_NAME = "user_name";
        public static final String COLUMN_USER_PASS = "user_pass";

        public static final String DATA_TABLE = "data_table";
        public static final String COLUMN_IMPACT_TIME = "impact_time";
        public static final String COLUMN_IMPACT_RANGE = "impact_range";
        public static final String COLUMN_INITIAL_HEIGHT = "initial_height";
        public static final String COLUMN_VELOCITY = "velocity";

        public HelperDB( Context context) {
            super(context, DB_FILE, null, 3);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String st = "CREATE TABLE " + USER_TABLE + " (" +
                    COLUMN_ID + " TEXT PRIMARY KEY, " +
                    COLUMN_USER_NAME + " TEXT, " +
                    COLUMN_USER_PASS + " TEXT)";

            String st2 = "CREATE TABLE " + DATA_TABLE + " (" +
                    COLUMN_IMPACT_TIME + " TEXT PRIMARY KEY, " +
                    COLUMN_IMPACT_RANGE + " TEXT, " +
                    COLUMN_INITIAL_HEIGHT + " TEXT, " +
                    COLUMN_VELOCITY + " TEXT)";


            db.execSQL(st);
            db.execSQL(st2);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(" DROP TABLE IF EXISTS " + USER_TABLE);
            db.execSQL(" DROP TABLE IF EXISTS " + DATA_TABLE);
            onCreate(db);

        }
    }


