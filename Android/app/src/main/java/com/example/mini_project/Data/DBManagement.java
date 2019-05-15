package com.example.mini_project.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mini_project.Model.User;
import com.example.mini_project.Utils.Attribute;

public class DBManagement extends SQLiteOpenHelper {
    private Context context;

    public DBManagement(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Attribute.DB_NAME, null, Attribute.DB_VERSION);
    }

    public DBManagement(Context context) {
        super(context, Attribute.DB_NAME, null, Attribute.DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create users table
        String CREATE_USERS_TABLE = "create table " + Attribute.DB_TABLE + "( " +
                Attribute.KEY_USERNAME + " text primary key," +
                Attribute.KEY_PASSWORD + " text," +
                Attribute.KEY_FULLNAME + " text," +
                Attribute.KEY_BIRTH + "date )";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //deleting table USERS
        db.execSQL(" drop table if exists " + Attribute.DB_TABLE);
        //create table
        onCreate(db);
    }

    // Add new user
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Attribute.KEY_USERNAME, user.getUsername());
        value.put(Attribute.KEY_PASSWORD, user.getPassword());
        value.put(Attribute.KEY_FULLNAME, user.getFullname());
        value.put(Attribute.KEY_BIRTH, user.getBirth());

        db.insert(Attribute.DB_TABLE, null, value);
        db.close();
    }

}