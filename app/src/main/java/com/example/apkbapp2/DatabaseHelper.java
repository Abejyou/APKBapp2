package com.example.apkbapp2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOME = "usuarios.db";
    private static final String TABLE_NOME = "usuarios";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOMEUSUARIO = "nomeUsuario";
    private static final String COLUMN_SENHA = "senha";

    private static final String TABLE_CREATE = "create table usuarios (id integer primary key autoincrement, " +
            "nome text not null, email text not null, nomeUsuario text not null, senha text not null)";

    public DatabaseHelper(Context context){
        super(context , DATABASE_NOME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( TABLE_CREATE );

        db.execSQL( "insert into usuarios(id, nome, email, nomeUsuario, senha)values(1,'abe','abe@abe.com', 'abejyou', '123' )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NOME;
        db.execSQL(query);
        this.onCreate( db );
    }
}
