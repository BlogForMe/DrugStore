package com.hyhy.hook.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Administrator on 2017/4/7.
 */

public class DbUtil {

    static DbUtil dbInstance;
    private static SQLiteDatabase db;

    public static DbUtil getDbInstance(Context context) {
        synchronized (DbUtil.class) {
            dbInstance = new DbUtil();
            DbSqlite mSqlite = new DbSqlite(context);
            db = mSqlite.getWritableDatabase();
        }
        return dbInstance;
    }


    static String dbName = "DbDInfo.db";
    static String TEXT_TYPES = " TEXT";//类型
    static final String COMMA_SEP = ",";
    static String CREATE_TABLE_DEVICE = "CREATE TABLE " + DevicePEntry.TABLE_DEVICE + " (" +
            DevicePEntry._ID + " INTEGER PRIMARY KEY," +
            DevicePEntry.imei + TEXT_TYPES + COMMA_SEP +
            DevicePEntry.imsi + TEXT_TYPES + COMMA_SEP +
            DevicePEntry.mac + TEXT_TYPES + COMMA_SEP +
            DevicePEntry.SimSerial + TEXT_TYPES +
            ")";

    static class DbSqlite extends SQLiteOpenHelper {
        private static final String SQL_DELETE_DEVICE = "DROP TABLE IF EXISTS " + DevicePEntry.TABLE_DEVICE;

        public DbSqlite(Context context) {
            super(context, dbName, null, Constants.DBVERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_DEVICE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(SQL_DELETE_DEVICE);
            onCreate(db);
        }
    }


    static abstract class DevicePEntry implements BaseColumns {
        public static final String TABLE_DEVICE = "DeviceParam";
        public static final String imei = "imei";
        public static final String imsi = "imsi";
        public static final String mac = "mac";
        public static final String SimSerial = "simserial";
    }


}
