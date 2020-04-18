package com.example.bookmydoctor;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBMS extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "Tabibyab.db";

    public DBMS(Context context){
        super(context, DATABASE_NAME ,null,1);
    }



    // create tables of data base
    public void onCreate(SQLiteDatabase db){
        // create table gender
        db.execSQL("create table gender(\n" +
                "  gender_id int not null primary key,\n" +
                "  title nvarchar(20)\n" +
                "  )");

        // create table user
        db.execSQL("create table user(\n" +
                "  phone_number nvarchar(20) not null primary key,\n" +
                "  gender_id int not null,\n" +
                "  first_name nvarchar(20),\n" +
                "  last_name nvarchar(20),\n" +
                "  password1 nvarchar(20),\n" +
                "  birth_day nvarchar(20),\n" +
                "  foreign key(gender_id) references gender(gender_id)\n" +
                "  )");

        // create table insurance

    }

    // drop all tables and call onCreate() method again
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

            onCreate(db);
        }

        public boolean login(User user){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from user where phone_number=? and password=?";
        Cursor cursor = db.rawQuery(sql, new String[]{user.getPhone_number(), user.getPassword()});
        cursor.moveToFirst();
        if(cursor.getCount() != 0)
            return true;
        return false;
    }

}
