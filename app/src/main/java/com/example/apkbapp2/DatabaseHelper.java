package com.example.apkbapp2;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOME = "usuario.db";
    private static final String TABLE_NOME = "usuario";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOMEUSUARIO = "nomeUsuario";
    private static final String COLUMN_SENHA = "senha";

    private static final String TABLE_CREATE = "create table usuario (id integer primary key not null auto_increment, " + "nome text not null, email text not null, nomeUsuario text not null, senha text not null);";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( TABLE_CREATE );
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NOME;

    }
}
