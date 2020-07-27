package com.example.apkbapp2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;

public class UsuarioHelper {
    private DatabaseHelper con;
    private SQLiteDatabase db;

    public UsuarioHelper(Context context){
        con = new DatabaseHelper( context );
        db = con.getWritableDatabase();
    }

    public long inserirUsuario(Usuario usuario){
        ContentValues values = new ContentValues(  );
        values.put( "nome", usuario.getNome() );
        values.put( "email", usuario.getEmail());
        values.put( "nomeUsuario", usuario.getNomeUsuario());
        values.put( "senha", usuario.getSenha());

        return db.insert("usuarios", null, values);
    }

    public Usuario buscarUsuario(int id){
        Usuario usuario = new Usuario();

        Cursor c = db.query( "usuarios", new String[]{"id", "nome", "email", "nomeUsuario", "senha"},null,null,null,null,null,null );
        if(c.moveToFirst()){
            do{
                if(id==c.getInt( 0 )) {
                    usuario.setId( c.getInt( 0 ) );
                    usuario.setNome( c.getString( 1 ) );
                    usuario.setEmail( c.getString( 2 ) );
                    usuario.setNomeUsuario( c.getString( 3 ) );
                    usuario.setSenha( c.getString( 4 ) );
                    break;
                }
            }while (c.moveToNext());
        }
        return usuario;
    }
    public Usuario login(String login, String senha){
        System.out.println( login + "\n"  + senha );
        Usuario usuario = new Usuario();
        Cursor c = db.query( "usuarios", new String[]{"id", "nome", "email", "nomeUsuario", "senha"},null,null,null,null,null,null );
        if(c.moveToFirst()){
            do{
                if(login.equals( c.getString( 3 ) )){
                    System.out.println( c.getString( 3 ) );
                    if (senha.equals( c.getString( 4 ) )){
                        usuario.setId( c.getInt( 0 ) );
                        usuario.setNome( c.getString( 1 ) );
                        usuario.setEmail( c.getString( 2 ) );
                        usuario.setNomeUsuario( c.getString( 3 ) );
                        usuario.setSenha( c.getString( 4 ) );
                        break;
                    }
                }

            }while (c.moveToNext());
        }
        System.out.println( usuario.getNomeUsuario() );
        return usuario;
    }


}
