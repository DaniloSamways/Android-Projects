package com.example.crud_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Bd extends SQLiteOpenHelper {
    public Bd(Context context){
        super(context, "pessoa.bd",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE pessoa("
                + "_id integer primary key autoincrement,"
                + "nome text,"
                + "cpf text"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}
}
